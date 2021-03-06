/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 * </copyright>
 *
 * $Id: ImperativeLoopExpItemProvider.java,v 1.3 2009/12/09 14:02:54 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeLoopExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLFactory;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.provider.LoopExpItemProvider;
import org.eclipse.ocl.expressions.ExpressionsPackage;


/**
 * This is the item provider adapter for a {@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeLoopExp} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ImperativeLoopExpItemProvider
	extends LoopExpItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeLoopExpItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ImperativeLoopExp)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ImperativeLoopExp_type") : //$NON-NLS-1$
			getString("_UI_ImperativeLoopExp_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ImperativeLoopExp.class)) {
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__CONDITION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createAltExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createAssertExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createAssignExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createBlockExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createBreakExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createCatchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createComputeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createContinueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createForExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createInstantiationExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createListLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createLogExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createRaiseExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createReturnExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createSwitchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createTryExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createUnlinkExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createUnpackExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createVariableInitExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.CALL_EXP__SOURCE,
				 ImperativeOCLFactory.eINSTANCE.createWhileExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createAltExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createAssertExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createAssignExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createBlockExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createBreakExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createCatchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createComputeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createContinueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createForExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createInstantiationExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createListLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createLogExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createRaiseExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createReturnExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createSwitchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createTryExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createUnlinkExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createUnpackExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createVariableInitExp()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.LOOP_EXP__BODY,
				 ImperativeOCLFactory.eINSTANCE.createWhileExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createAltExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createAssertExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createAssignExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createBlockExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createBreakExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createCatchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createComputeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createContinueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createDictLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createForExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createImperativeIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createInstantiationExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createListLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createLogExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createOrderedTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createRaiseExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createReturnExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createSwitchExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createTryExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createUnlinkExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createUnpackExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createVariableInitExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 ImperativeOCLFactory.eINSTANCE.createWhileExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION,
				 EcoreFactory.eINSTANCE.createVariableExp()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ExpressionsPackage.Literals.CALL_EXP__SOURCE ||
			childFeature == ExpressionsPackage.Literals.LOOP_EXP__BODY ||
			childFeature == ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP__CONDITION;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ImperativeOCLEditPlugin.INSTANCE;
	}

}
