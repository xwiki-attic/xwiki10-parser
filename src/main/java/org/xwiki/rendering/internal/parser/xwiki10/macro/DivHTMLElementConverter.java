/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.internal.parser.xwiki10.macro;

import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.rendering.internal.parser.xwiki10.HTMLFilter.HTMLFilterContext;
import org.xwiki.rendering.parser.xwiki10.macro.AbstractHTMLElementConverter;

@Component
@Named("div")
@Singleton
public class DivHTMLElementConverter extends AbstractHTMLElementConverter
{
    @Override
    public String convert(String name, Map<String, String> parameters, String content, HTMLFilterContext filterContext)
    {
        StringBuffer result = new StringBuffer();

        if (parameters.size() > 0) {
            StringBuffer parametersSyntax = new StringBuffer();
            parametersSyntax.append("(% ");
            appendParameters(parametersSyntax, parameters, filterContext);
            parametersSyntax.append(" %)");
            result.append(filterContext.getFilterContext().addProtectedContent(parametersSyntax.toString(), false));
        }

        result.append(filterContext.getFilterContext().addProtectedContent("(((", false));
        if (content != null) {
            result.append(filterContext.cleanContent(content));
        }
        result.append(filterContext.getFilterContext().addProtectedContent(")))", false));

        return result.toString();
    }

    @Override
    public boolean isInline()
    {
        return false;
    }
}
