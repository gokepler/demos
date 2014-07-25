/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
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
package org.jboss.arquillian.secureejb.demo;

import static org.jboss.arquillian.secureejb.demo.SecurityRoles.ROLE1;
import static org.jboss.arquillian.secureejb.demo.SecurityRoles.ROLE2;
import static org.jboss.arquillian.secureejb.demo.SecurityRoles.ROLE3;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 * Session Bean demonstrating access to the caller principal
 */
@Stateless
@LocalBean
@DeclareRoles({ ROLE1, ROLE2, ROLE3 })
public class CallerPrincipalDemoSessionBean {

    @Resource
    private SessionContext sessionContext;

    @PermitAll
    public String getCallerPrincipalName() {
        return sessionContext.getCallerPrincipal().getName();
    }

}
