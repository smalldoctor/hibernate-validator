/*
* JBoss, Home of Professional Open Source
* Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.hibernate.validator.internal.metadata.descriptor;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.validation.metadata.MethodDescriptor;
import javax.validation.metadata.ParameterDescriptor;
import javax.validation.metadata.ReturnValueDescriptor;

/**
 * Describes a validated method.
 *
 * @author Gunnar Morling
 */
public class MethodDescriptorImpl extends ElementDescriptorImpl implements MethodDescriptor {
	private final String name;
	private final List<ParameterDescriptor> parameters;
	private final ReturnValueDescriptor returnValueDescriptor;

	public MethodDescriptorImpl(Class<?> returnType,
								String name,
								Set<ConstraintDescriptorImpl<?>> returnValueConstraints,
								ReturnValueDescriptor returnValueDescriptor,
								List<ParameterDescriptor> parameters,
								boolean defaultGroupSequenceRedefined,
								List<Class<?>> defaultGroupSequence) {
		super( returnType, returnValueConstraints, defaultGroupSequenceRedefined, defaultGroupSequence );

		this.name = name;
		this.parameters = Collections.unmodifiableList( parameters );
		this.returnValueDescriptor = returnValueDescriptor;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<ParameterDescriptor> getParameterDescriptors() {
		return parameters;
	}

	@Override
	public ReturnValueDescriptor getReturnValueDescriptor() {
		return returnValueDescriptor;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append( "MethodDescriptorImpl" );
		sb.append( "{name='" ).append( name ).append( '\'' );
		sb.append( '}' );
		return sb.toString();
	}

	@Override
	public Kind getKind() {
		return Kind.METHOD;
	}
}
