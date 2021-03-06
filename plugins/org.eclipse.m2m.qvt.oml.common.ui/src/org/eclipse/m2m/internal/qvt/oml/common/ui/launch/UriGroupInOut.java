package org.eclipse.m2m.internal.qvt.oml.common.ui.launch;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IChooser;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.swt.widgets.Composite;

public class UriGroupInOut extends UriGroupIn {

	public UriGroupInOut(Composite parent, String name, ResourceSet validationRS) {
    	super(parent, name, validationRS);
    	myValidationRS = validationRS;
    }
    
    @Override
    protected IChooser getChooser(IMetamodelHandler handler) {
    	return handler.getSourceChooser(myValidationRS);
    }

    private ResourceSet myValidationRS;

}
