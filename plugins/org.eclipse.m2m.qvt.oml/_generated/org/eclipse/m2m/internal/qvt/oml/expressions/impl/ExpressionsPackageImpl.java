/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *
 * $Id: ExpressionsPackageImpl.java,v 1.20 2009/01/11 23:22:08 radvorak Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.expressions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.expressions.ConstructorBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.EntryOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExtendedVisitor;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Rename;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.VisitableASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsPackageImpl extends EPackageImpl implements ExpressionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextualPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass helperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitableASTNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveInExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationalTransformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage#eNS_URI
	 * @see #init()
	 * @generated NOT
	 */
	private ExpressionsPackageImpl() {
		super(eNS_URI, ExpressionsFactory.eINSTANCE);

		QVTO_ROOT_PACKAGE.getESubpackages().add(this);
	}

	/**
	 * Root package of the QVT Operational model, which we have to "fake out"
	 * because EMF will not generate it.
	 */
	public static final EPackage QVTO_ROOT_PACKAGE;
	
	static {
        class QVTOPackageImpl extends EPackageImpl {
			@Override
			protected Resource createResource(String uri) {
				return super.createResource(uri);
			}
		}
        
        QVTOPackageImpl qvtoPackage = new QVTOPackageImpl();
        qvtoPackage.setName("qvtoperational"); //$NON-NLS-1$
        qvtoPackage.setNsPrefix("qvtoperational"); //$NON-NLS-1$
        qvtoPackage.setNsURI("http://www.eclipse.org/QVT/1.0.0/Operational"); //$NON-NLS-1$
        qvtoPackage.createResource(qvtoPackage.getNsURI());
		
		QVTO_ROOT_PACKAGE = qvtoPackage;
		EPackage.Registry.INSTANCE.put(QVTO_ROOT_PACKAGE.getNsURI(), QVTO_ROOT_PACKAGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpressionsPackage init() {
		if (isInited) return (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Obtain or create and register package
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExpressionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ImperativeOCLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExpressionsPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExpressionsPackage.freeze();

		return theExpressionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_OwnedVariable() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_ModuleImport() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_UsedModelType() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_ConfigProperty() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_OwnedRenaming() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Entry() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibrary() {
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRename() {
		return renameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRename_NewName() {
		return (EAttribute)renameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleImport() {
		return moduleImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleImport_Module() {
		return (EReference)moduleImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleImport_ImportedModule() {
		return (EReference)moduleImportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextualProperty() {
		return contextualPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualProperty_Context() {
		return (EReference)contextualPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualProperty_Overridden() {
		return (EReference)contextualPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualProperty_InitExpression() {
		return (EReference)contextualPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeOperation() {
		return imperativeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeOperation_Context() {
		return (EReference)imperativeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeOperation_Result() {
		return (EReference)imperativeOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeOperation_Body() {
		return (EReference)imperativeOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImperativeOperation_IsBlackbox() {
		return (EAttribute)imperativeOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelParameter() {
		return modelParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVarParameter() {
		return varParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarParameter_CtxOwner() {
		return (EReference)varParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarParameter_ResOwner() {
		return (EReference)varParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarParameter_Kind() {
		return (EAttribute)varParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationBody() {
		return operationBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationBody_Operation() {
		return (EReference)operationBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationBody_Content() {
		return (EReference)operationBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationBody_Variable() {
		return (EReference)operationBodyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructorBody() {
		return constructorBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingOperation() {
		return mappingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperation_When() {
		return (EReference)mappingOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperation_Inherited() {
		return (EReference)mappingOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperation_Merged() {
		return (EReference)mappingOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperation_Disjunct() {
		return (EReference)mappingOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHelper() {
		return helperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHelper_IsQuery() {
		return (EAttribute)helperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingBody() {
		return mappingBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingBody_InitSection() {
		return (EReference)mappingBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingBody_EndSection() {
		return (EReference)mappingBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingCallExp() {
		return mappingCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingCallExp_IsStrict() {
		return (EAttribute)mappingCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectExp() {
		return objectExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectExp_Body() {
		return (EReference)objectExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectExp_ReferredObject() {
		return (EReference)objectExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedVisitor() {
		return extendedVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitableASTNode() {
		return visitableASTNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveExp() {
		return resolveExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExp_One() {
		return (EAttribute)resolveExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExp_IsInverse() {
		return (EAttribute)resolveExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExp_IsDeferred() {
		return (EAttribute)resolveExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveExp_Target() {
		return (EReference)resolveExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveExp_Condition() {
		return (EReference)resolveExpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveInExp() {
		return resolveInExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveInExp_InMappings() {
		return (EReference)resolveInExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelType() {
		return modelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelType_AdditionalCondition() {
		return (EReference)modelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelType_ConformanceKind() {
		return (EAttribute)modelTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelType_Metamodel() {
		return (EReference)modelTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingParameter() {
		return mappingParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingParameter_Extent() {
		return (EReference)mappingParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationalTransformation() {
		return operationalTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationalTransformation_IntermediateClass() {
		return (EReference)operationalTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationalTransformation_IntermediateProperty() {
		return (EReference)operationalTransformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationalTransformation_ModelParameter() {
		return (EReference)operationalTransformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntryOperation() {
		return entryOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirectionKind() {
		return directionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsFactory getExpressionsFactory() {
		return (ExpressionsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		moduleEClass = createEClass(MODULE);
		createEReference(moduleEClass, MODULE__OWNED_VARIABLE);
		createEReference(moduleEClass, MODULE__MODULE_IMPORT);
		createEReference(moduleEClass, MODULE__USED_MODEL_TYPE);
		createEReference(moduleEClass, MODULE__CONFIG_PROPERTY);
		createEReference(moduleEClass, MODULE__OWNED_RENAMING);
		createEReference(moduleEClass, MODULE__ENTRY);

		libraryEClass = createEClass(LIBRARY);

		renameEClass = createEClass(RENAME);
		createEAttribute(renameEClass, RENAME__NEW_NAME);

		moduleImportEClass = createEClass(MODULE_IMPORT);
		createEReference(moduleImportEClass, MODULE_IMPORT__MODULE);
		createEReference(moduleImportEClass, MODULE_IMPORT__IMPORTED_MODULE);

		classEClass = createEClass(CLASS);

		contextualPropertyEClass = createEClass(CONTEXTUAL_PROPERTY);
		createEReference(contextualPropertyEClass, CONTEXTUAL_PROPERTY__CONTEXT);
		createEReference(contextualPropertyEClass, CONTEXTUAL_PROPERTY__OVERRIDDEN);
		createEReference(contextualPropertyEClass, CONTEXTUAL_PROPERTY__INIT_EXPRESSION);

		imperativeOperationEClass = createEClass(IMPERATIVE_OPERATION);
		createEReference(imperativeOperationEClass, IMPERATIVE_OPERATION__CONTEXT);
		createEReference(imperativeOperationEClass, IMPERATIVE_OPERATION__RESULT);
		createEReference(imperativeOperationEClass, IMPERATIVE_OPERATION__BODY);
		createEAttribute(imperativeOperationEClass, IMPERATIVE_OPERATION__IS_BLACKBOX);

		modelParameterEClass = createEClass(MODEL_PARAMETER);

		varParameterEClass = createEClass(VAR_PARAMETER);
		createEReference(varParameterEClass, VAR_PARAMETER__CTX_OWNER);
		createEReference(varParameterEClass, VAR_PARAMETER__RES_OWNER);
		createEAttribute(varParameterEClass, VAR_PARAMETER__KIND);

		operationBodyEClass = createEClass(OPERATION_BODY);
		createEReference(operationBodyEClass, OPERATION_BODY__OPERATION);
		createEReference(operationBodyEClass, OPERATION_BODY__CONTENT);
		createEReference(operationBodyEClass, OPERATION_BODY__VARIABLE);

		constructorBodyEClass = createEClass(CONSTRUCTOR_BODY);

		mappingOperationEClass = createEClass(MAPPING_OPERATION);
		createEReference(mappingOperationEClass, MAPPING_OPERATION__WHEN);
		createEReference(mappingOperationEClass, MAPPING_OPERATION__INHERITED);
		createEReference(mappingOperationEClass, MAPPING_OPERATION__MERGED);
		createEReference(mappingOperationEClass, MAPPING_OPERATION__DISJUNCT);

		helperEClass = createEClass(HELPER);
		createEAttribute(helperEClass, HELPER__IS_QUERY);

		mappingBodyEClass = createEClass(MAPPING_BODY);
		createEReference(mappingBodyEClass, MAPPING_BODY__INIT_SECTION);
		createEReference(mappingBodyEClass, MAPPING_BODY__END_SECTION);

		mappingCallExpEClass = createEClass(MAPPING_CALL_EXP);
		createEAttribute(mappingCallExpEClass, MAPPING_CALL_EXP__IS_STRICT);

		objectExpEClass = createEClass(OBJECT_EXP);
		createEReference(objectExpEClass, OBJECT_EXP__BODY);
		createEReference(objectExpEClass, OBJECT_EXP__REFERRED_OBJECT);

		extendedVisitorEClass = createEClass(EXTENDED_VISITOR);

		visitableASTNodeEClass = createEClass(VISITABLE_AST_NODE);

		resolveExpEClass = createEClass(RESOLVE_EXP);
		createEAttribute(resolveExpEClass, RESOLVE_EXP__ONE);
		createEAttribute(resolveExpEClass, RESOLVE_EXP__IS_INVERSE);
		createEAttribute(resolveExpEClass, RESOLVE_EXP__IS_DEFERRED);
		createEReference(resolveExpEClass, RESOLVE_EXP__TARGET);
		createEReference(resolveExpEClass, RESOLVE_EXP__CONDITION);

		resolveInExpEClass = createEClass(RESOLVE_IN_EXP);
		createEReference(resolveInExpEClass, RESOLVE_IN_EXP__IN_MAPPINGS);

		modelTypeEClass = createEClass(MODEL_TYPE);
		createEReference(modelTypeEClass, MODEL_TYPE__ADDITIONAL_CONDITION);
		createEAttribute(modelTypeEClass, MODEL_TYPE__CONFORMANCE_KIND);
		createEReference(modelTypeEClass, MODEL_TYPE__METAMODEL);

		mappingParameterEClass = createEClass(MAPPING_PARAMETER);
		createEReference(mappingParameterEClass, MAPPING_PARAMETER__EXTENT);

		operationalTransformationEClass = createEClass(OPERATIONAL_TRANSFORMATION);
		createEReference(operationalTransformationEClass, OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS);
		createEReference(operationalTransformationEClass, OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY);
		createEReference(operationalTransformationEClass, OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER);

		entryOperationEClass = createEClass(ENTRY_OPERATION);

		// Create enums
		directionKindEEnum = createEEnum(DIRECTION_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		org.eclipse.ocl.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.ocl.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.ocl.ecore.EcorePackage.eNS_URI);
		UtilitiesPackage theUtilitiesPackage = (UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);
		org.eclipse.ocl.expressions.ExpressionsPackage theExpressionsPackage_1 = (org.eclipse.ocl.expressions.ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.ocl.expressions.ExpressionsPackage.eNS_URI);
		ImperativeOCLPackage theImperativeOCLPackage = (ImperativeOCLPackage)EPackage.Registry.INSTANCE.getEPackage(ImperativeOCLPackage.eNS_URI);

		// Create type parameters
		ETypeParameter extendedVisitorEClass_T = addETypeParameter(extendedVisitorEClass, "T"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes
		moduleEClass.getESuperTypes().add(theEcorePackage.getEClass());
		moduleEClass.getESuperTypes().add(theEcorePackage.getEPackage());
		moduleEClass.getESuperTypes().add(this.getVisitableASTNode());
		libraryEClass.getESuperTypes().add(this.getModule());
		renameEClass.getESuperTypes().add(theEcorePackage.getETypedElement());
		renameEClass.getESuperTypes().add(this.getVisitableASTNode());
		moduleImportEClass.getESuperTypes().add(this.getVisitableASTNode());
		classEClass.getESuperTypes().add(theEcorePackage.getEClass());
		classEClass.getESuperTypes().add(this.getVisitableASTNode());
		contextualPropertyEClass.getESuperTypes().add(theEcorePackage.getEStructuralFeature());
		contextualPropertyEClass.getESuperTypes().add(this.getVisitableASTNode());
		imperativeOperationEClass.getESuperTypes().add(theEcorePackage.getEOperation());
		imperativeOperationEClass.getESuperTypes().add(this.getVisitableASTNode());
		modelParameterEClass.getESuperTypes().add(this.getVarParameter());
		varParameterEClass.getESuperTypes().add(theEcorePackage_1.getVariable());
		varParameterEClass.getESuperTypes().add(theEcorePackage.getEParameter());
		operationBodyEClass.getESuperTypes().add(this.getVisitableASTNode());
		constructorBodyEClass.getESuperTypes().add(this.getOperationBody());
		mappingOperationEClass.getESuperTypes().add(this.getImperativeOperation());
		helperEClass.getESuperTypes().add(this.getImperativeOperation());
		mappingBodyEClass.getESuperTypes().add(this.getOperationBody());
		mappingCallExpEClass.getESuperTypes().add(theEcorePackage_1.getOperationCallExp());
		objectExpEClass.getESuperTypes().add(theImperativeOCLPackage.getInstantiationExp());
		EGenericType g1 = createEGenericType(theImperativeOCLPackage.getImperativeOCLVisitor());
		EGenericType g2 = createEGenericType(extendedVisitorEClass_T);
		g1.getETypeArguments().add(g2);
		extendedVisitorEClass.getEGenericSuperTypes().add(g1);
		visitableASTNodeEClass.getESuperTypes().add(theUtilitiesPackage.getVisitable());
		visitableASTNodeEClass.getESuperTypes().add(theUtilitiesPackage.getASTNode());
		resolveExpEClass.getESuperTypes().add(theEcorePackage_1.getCallExp());
		resolveInExpEClass.getESuperTypes().add(this.getResolveExp());
		modelTypeEClass.getESuperTypes().add(theEcorePackage.getEClass());
		modelTypeEClass.getESuperTypes().add(this.getVisitableASTNode());
		mappingParameterEClass.getESuperTypes().add(this.getVarParameter());
		operationalTransformationEClass.getESuperTypes().add(this.getModule());
		entryOperationEClass.getESuperTypes().add(this.getImperativeOperation());

		// Initialize classes and features; add operations and parameters
		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModule_OwnedVariable(), theEcorePackage_1.getVariable(), null, "ownedVariable", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getModule_ModuleImport(), this.getModuleImport(), this.getModuleImport_Module(), "moduleImport", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModule_UsedModelType(), this.getModelType(), null, "usedModelType", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModule_ConfigProperty(), theEcorePackage.getEStructuralFeature(), null, "configProperty", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModule_OwnedRenaming(), this.getRename(), null, "ownedRenaming", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModule_Entry(), this.getEntryOperation(), null, "entry", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(moduleEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		ETypeParameter t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		ETypeParameter t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = addEOperation(libraryEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(renameEClass, Rename.class, "Rename", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getRename_NewName(), theEcorePackage.getEString(), "newName", null, 0, 1, Rename.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(renameEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(moduleImportEClass, ModuleImport.class, "ModuleImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModuleImport_Module(), this.getModule(), this.getModule_ModuleImport(), "module", null, 0, 1, ModuleImport.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModuleImport_ImportedModule(), this.getModule(), null, "importedModule", null, 1, 1, ModuleImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(moduleImportEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(classEClass, org.eclipse.m2m.internal.qvt.oml.expressions.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = addEOperation(classEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(contextualPropertyEClass, ContextualProperty.class, "ContextualProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getContextualProperty_Context(), theEcorePackage.getEClass(), null, "context", null, 1, 1, ContextualProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getContextualProperty_Overridden(), theEcorePackage.getEStructuralFeature(), null, "overridden", null, 0, 1, ContextualProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(theExpressionsPackage_1.getOCLExpression());
		g2 = createEGenericType(theEcorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		initEReference(getContextualProperty_InitExpression(), g1, null, "initExpression", null, 0, 1, ContextualProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(contextualPropertyEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(imperativeOperationEClass, ImperativeOperation.class, "ImperativeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getImperativeOperation_Context(), this.getVarParameter(), this.getVarParameter_CtxOwner(), "context", null, 0, 1, ImperativeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getImperativeOperation_Result(), this.getVarParameter(), this.getVarParameter_ResOwner(), "result", null, 0, -1, ImperativeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getImperativeOperation_Body(), this.getOperationBody(), this.getOperationBody_Operation(), "body", null, 0, 1, ImperativeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getImperativeOperation_IsBlackbox(), theEcorePackage.getEBoolean(), "isBlackbox", null, 0, 1, ImperativeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(imperativeOperationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(modelParameterEClass, ModelParameter.class, "ModelParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(varParameterEClass, VarParameter.class, "VarParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getVarParameter_CtxOwner(), this.getImperativeOperation(), this.getImperativeOperation_Context(), "ctxOwner", null, 0, 1, VarParameter.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVarParameter_ResOwner(), this.getImperativeOperation(), this.getImperativeOperation_Result(), "resOwner", null, 0, 1, VarParameter.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVarParameter_Kind(), this.getDirectionKind(), "kind", null, 0, 1, VarParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(varParameterEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(operationBodyEClass, OperationBody.class, "OperationBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperationBody_Operation(), this.getImperativeOperation(), this.getImperativeOperation_Body(), "operation", null, 0, 1, OperationBody.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationBody_Content(), theEcorePackage_1.getOCLExpression(), null, "content", null, 0, -1, OperationBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(theExpressionsPackage_1.getVariable());
		g2 = createEGenericType(theEcorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEParameter());
		g1.getETypeArguments().add(g2);
		initEReference(getOperationBody_Variable(), g1, null, "variable", null, 0, -1, OperationBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(operationBodyEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(constructorBodyEClass, ConstructorBody.class, "ConstructorBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mappingOperationEClass, MappingOperation.class, "MappingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		g1 = createEGenericType(theExpressionsPackage_1.getOCLExpression());
		g2 = createEGenericType(theEcorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		initEReference(getMappingOperation_When(), g1, null, "when", null, 0, -1, MappingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingOperation_Inherited(), this.getMappingOperation(), null, "inherited", null, 0, -1, MappingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingOperation_Merged(), this.getMappingOperation(), null, "merged", null, 0, -1, MappingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingOperation_Disjunct(), this.getMappingOperation(), null, "disjunct", null, 0, -1, MappingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(mappingOperationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(helperEClass, Helper.class, "Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getHelper_IsQuery(), theEcorePackage.getEBoolean(), "isQuery", null, 0, 1, Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(helperEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(mappingBodyEClass, MappingBody.class, "MappingBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		g1 = createEGenericType(theExpressionsPackage_1.getOCLExpression());
		g2 = createEGenericType(theEcorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		initEReference(getMappingBody_InitSection(), g1, null, "initSection", null, 0, -1, MappingBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(theExpressionsPackage_1.getOCLExpression());
		g2 = createEGenericType(theEcorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		initEReference(getMappingBody_EndSection(), g1, null, "endSection", null, 0, -1, MappingBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(mappingBodyEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(mappingCallExpEClass, MappingCallExp.class, "MappingCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMappingCallExp_IsStrict(), theEcorePackage.getEBoolean(), "isStrict", null, 0, 1, MappingCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(mappingCallExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(objectExpEClass, ObjectExp.class, "ObjectExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getObjectExp_Body(), this.getConstructorBody(), null, "body", null, 0, 1, ObjectExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(theExpressionsPackage_1.getVariable());
		g2 = createEGenericType(theEcorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEParameter());
		g1.getETypeArguments().add(g2);
		initEReference(getObjectExp_ReferredObject(), g1, null, "referredObject", null, 1, 1, ObjectExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(objectExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(extendedVisitorEClass, ExtendedVisitor.class, "ExtendedVisitor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = addEOperation(extendedVisitorEClass, null, "visitModule", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getModule(), "module", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitLibrary", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getLibrary(), "library", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitRename", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getRename(), "rename", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitModuleImport", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getModuleImport(), "moduleImport", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitClass", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getClass_(), "class_", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitContextualProperty", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getContextualProperty(), "contextualProperty", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitImperativeOperation", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getImperativeOperation(), "imperativeOperation", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitVarParameter", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getVarParameter(), "varParameter", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitOperationBody", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getOperationBody(), "operationBody", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitMappingOperation", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getMappingOperation(), "mappingOperation", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitHelper", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getHelper(), "helper", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitMappingBody", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getMappingBody(), "mappingBody", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitMappingCallExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getMappingCallExp(), "mappingCallExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitResolveExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getResolveExp(), "resolveExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitResolveInExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getResolveInExp(), "resolveInExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitObjectExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getObjectExp(), "objectExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitModelType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getModelType(), "modelType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(extendedVisitorEClass, null, "visitEntryOperation", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getEntryOperation(), "entryOperation", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(extendedVisitorEClass_T);
		initEOperation(op, g1);

		initEClass(visitableASTNodeEClass, VisitableASTNode.class, "VisitableASTNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(resolveExpEClass, ResolveExp.class, "ResolveExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getResolveExp_One(), theEcorePackage.getEBoolean(), "one", null, 1, 1, ResolveExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getResolveExp_IsInverse(), theEcorePackage.getEBoolean(), "isInverse", null, 1, 1, ResolveExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getResolveExp_IsDeferred(), theEcorePackage.getEBoolean(), "isDeferred", null, 1, 1, ResolveExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(theExpressionsPackage_1.getVariable());
		g2 = createEGenericType(theEcorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEParameter());
		g1.getETypeArguments().add(g2);
		initEReference(getResolveExp_Target(), g1, null, "target", null, 0, 1, ResolveExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(theExpressionsPackage_1.getOCLExpression());
		g2 = createEGenericType(theEcorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		initEReference(getResolveExp_Condition(), g1, null, "condition", null, 0, 1, ResolveExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(resolveExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(resolveInExpEClass, ResolveInExp.class, "ResolveInExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getResolveInExp_InMappings(), this.getMappingOperation(), null, "inMappings", null, 0, -1, ResolveInExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(resolveInExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(modelTypeEClass, ModelType.class, "ModelType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		g1 = createEGenericType(theExpressionsPackage_1.getOCLExpression());
		g2 = createEGenericType(theEcorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		initEReference(getModelType_AdditionalCondition(), g1, null, "additionalCondition", null, 0, -1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getModelType_ConformanceKind(), theEcorePackage.getEString(), "conformanceKind", null, 0, 1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModelType_Metamodel(), theEcorePackage.getEPackage(), null, "metamodel", null, 1, -1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(modelTypeEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(mappingParameterEClass, MappingParameter.class, "MappingParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getMappingParameter_Extent(), this.getModelParameter(), null, "extent", null, 0, 1, MappingParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operationalTransformationEClass, OperationalTransformation.class, "OperationalTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperationalTransformation_IntermediateClass(), theEcorePackage.getEClass(), null, "intermediateClass", null, 0, -1, OperationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationalTransformation_IntermediateProperty(), theEcorePackage.getEStructuralFeature(), null, "intermediateProperty", null, 0, -1, OperationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationalTransformation_ModelParameter(), this.getModelParameter(), null, "modelParameter", null, 0, -1, OperationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(entryOperationEClass, EntryOperation.class, "EntryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = addEOperation(entryOperationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		// Initialize enums and add enum literals
		initEEnum(directionKindEEnum, DirectionKind.class, "DirectionKind"); //$NON-NLS-1$
		addEEnumLiteral(directionKindEEnum, DirectionKind.IN);
		addEEnumLiteral(directionKindEEnum, DirectionKind.INOUT);
		addEEnumLiteral(directionKindEEnum, DirectionKind.OUT);

		// Create resource
		createResource(eNS_URI);
	}

} //ExpressionsPackageImpl
