/*******************************************************************************
 * Copyright (c) 2013 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.fusesource.ide.project.providers;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.fusesource.ide.project.Activator;

public class CamelVirtualFolder {
	
	private IProject project;
	private ArrayList<IResource> camelFiles = new ArrayList<IResource>();

	/**
	 * 
	 */
	public CamelVirtualFolder(IProject prj) {
		this.project = prj;
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new CamelVirtualFolderListener(project), IResourceChangeEvent.POST_CHANGE | IResourceChangeEvent.PRE_REFRESH);
	}

	/**
	 * @return the project
	 */
	public IProject getProject() {
		return this.project;
	}

	public String getName() {
		return "Camel Contexts";
	}

	public void addCamelFile(IResource file) {
		if (!this.camelFiles.contains(file)) {
			this.camelFiles.add(file);
		}
	}

	/**
	 * @return the camelFiles
	 */
	public ArrayList<IResource> getCamelFiles() {
		return this.camelFiles;
	}

	public void populateChildren() {
		IPath p = project.getLocation();
		if (p != null) {
			try {
				findFiles(p.toFile());
			} catch (CoreException ex) {
				// ignore
			}
		}
	}

	private void findFiles(File folder) throws CoreException {
		File[] files = folder.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					// ignore the target folder
					if (f.getName().equalsIgnoreCase("target")
							&& f.getParentFile().getName()
									.equalsIgnoreCase(project.getName()))
						continue;
					findFiles(f);
				} else {
					IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(Path.fromOSString(f.getPath()));
					if (ifile != null
							&& ifile.getContentDescription() != null
							&& ifile.getContentDescription()
									.getContentType()
									.getId()
									.equals("org.fusesource.ide.camel.editor.camelContentType")) {
						addCamelFile(ifile);
					}
				}
			}

		}
	}

	class CamelVirtualFolderListener implements IResourceChangeListener {

		private IProject _project;

		/**
		 * 
		 */
		public CamelVirtualFolderListener(IProject project) {
			this._project = project;
		}

		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			if (event.getType() == IResourceChangeEvent.PRE_REFRESH) {
				camelFiles.clear();
				populateChildren();
			} else if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
				try {
					event.getDelta().accept(new DeltaPrinter(_project));
				} catch (CoreException ex) {
					Activator.getLogger().error(ex);
				}
			}
		}
	}

	class DeltaPrinter implements IResourceDeltaVisitor {

		private IProject _project;

		/**
		 * 
		 */
		public DeltaPrinter(IProject project) {
			this._project = project;
		}

		@Override
		public boolean visit(IResourceDelta delta) {
			IResource resource = delta.getResource();

			if (resource.getProject() != null
					&& !resource.getProject().equals(project)) {
				// we are not interested in changes of other projects
				return true;
			}

			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				if (resource
						.getFullPath()
						.toOSString()
						.contains(
								File.separator + "target" + File.separator
										+ "classes" + File.separator)) {
					// skip target folder
					break;
				}
				// a resource was added, check if we need to add it the the
				// camel virtual folder too
				try {
					if (resource != null
							&& resource instanceof IFile
							&& ((IFile) resource).getContentDescription() != null
							&& ((IFile) resource)
									.getContentDescription()
									.getContentType()
									.getId()
									.equals("org.fusesource.ide.camel.editor.camelContentType")) {
						addCamelFile(resource);
					}
				} catch (CoreException ex) {
					// ignore file
				}
				break;
			case IResourceDelta.REMOVED:
				// a resource has been removed, check if we need to remove
				// it from the virtual camel folder
				if (camelFiles.contains(resource)) {
					camelFiles.remove(resource);
				}
				break;
			}
			return true; // visit the children
		}
	}
}