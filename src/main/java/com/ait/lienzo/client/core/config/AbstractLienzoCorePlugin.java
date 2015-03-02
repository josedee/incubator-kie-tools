/*
   Copyright (c) 2014,2015 Ahome' Innovation Technologies. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.ait.lienzo.client.core.config;

import java.util.Collection;

import com.ait.lienzo.client.core.shape.json.IFactory;
import com.ait.lienzo.client.core.types.NFastStringMap;
import com.ait.lienzo.shared.java.util.IStringValuedType;
import com.ait.lienzo.shared.java.util.function.Supplier;

public abstract class AbstractLienzoCorePlugin implements ILienzoPlugin
{
    private final NFastStringMap<IFactory<?>>           m_factories = new NFastStringMap<IFactory<?>>();

    private final NFastStringMap<Supplier<IFactory<?>>> m_suppliers = new NFastStringMap<Supplier<IFactory<?>>>();

    protected AbstractLienzoCorePlugin()
    {
    }

    protected final void add(final IStringValuedType type, final Supplier<IFactory<?>> supplier)
    {
        final String name = type.getValue();

        if (null != m_suppliers.get(name))
        {
            LienzoCore.get().error("Supplier for type " + name + "  has already been defined.");
        }
        else
        {
            m_suppliers.put(name, supplier);
        }
    }

    @Override
    public Collection<String> keys()
    {
        return m_suppliers.keys();
    }

    @Override
    public IFactory<?> getFactory(final IStringValuedType type)
    {
        return getFactory(type.getValue());
    }

    @Override
    public IFactory<?> getFactory(final String name)
    {
        IFactory<?> factory = m_factories.get(name);

        if (null != factory)
        {
            return factory;
        }
        final Supplier<IFactory<?>> supplier = m_suppliers.get(name);

        if (null != supplier)
        {
            factory = supplier.get();

            if (null != factory)
            {
                m_factories.put(name, factory);

                return factory;
            }
        }
        return null;
    }
}
