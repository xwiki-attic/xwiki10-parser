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
package org.xwiki.rendering.parser.xwiki10.macro;

import org.xwiki.component.annotation.Role;
import org.xwiki.rendering.parser.xwiki10.FilterContext;

/**
 * Convert Velocity macro to XWiki 2.0 syntax or macro.
 *
 * @version $Id$
 * @since 1.8M1
 */
@Role
public interface RadeoxMacroConverter
{
    final static int PARAMETER_SIMPLE = 0;

    final static int PARAMETER_NOTNONE = 1;

    final static int PARAMETER_NOTEMPTY = 2;

    final static int PARAMETER_NOTEMPTYNONE = PARAMETER_NOTNONE | PARAMETER_NOTEMPTY;

    String getParameterName(int parameterIndex);

    int getParameterType(int parameterIndex);

    boolean supportContent();

    boolean protectResult();

    boolean isInline();

    String convert(String name, RadeoxMacroParameters parameters, String content, FilterContext filterContext);
}
