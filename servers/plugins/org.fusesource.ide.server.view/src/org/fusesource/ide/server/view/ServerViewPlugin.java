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

package org.fusesource.ide.server.view;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.fusesource.ide.commons.logging.RiderLogFacade;
import org.osgi.framework.BundleContext;


/**
 * @author lhein
 */
public class ServerViewPlugin extends AbstractUIPlugin {
	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.fusesource.ide.server.view";

	public static final String TERMINAL_VIEW_ID = "org.fusesource.ide.server.view.TerminalView";
	
	// The shared instance
	private static ServerViewPlugin plugin;
	private static IViewPart part;
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ServerViewPlugin getDefault() {
		return plugin;
	}

	/**
	 * The constructor
	 */
	public ServerViewPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	/**
	 * opens the properties view if not already open
	 */
	public static IViewPart openTerminalView() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IWorkbench wb = PlatformUI.getWorkbench();
				if (wb != null) {
					IWorkbenchWindow activeWindow = wb.getActiveWorkbenchWindow();
					if (activeWindow != null) {
						IWorkbenchPage activePage = activeWindow.getActivePage();
						if (activePage != null) {
							try { 
								part = activePage.showView(TERMINAL_VIEW_ID);
							} catch (CoreException ex) {
								getLogger().error("Unable to create the terminal view!", ex);
							}
						}
					}
				}
			}
		});
		return part;
	}
	
	public static RiderLogFacade getLogger() {
		return RiderLogFacade.getLog(getDefault().getLog());
	}
}