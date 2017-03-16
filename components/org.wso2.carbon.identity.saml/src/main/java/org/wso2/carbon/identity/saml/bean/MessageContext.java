/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.saml.bean;

import org.wso2.carbon.identity.gateway.context.AuthenticationContext;
import org.wso2.carbon.identity.saml.model.RequestValidatorConfig;
import org.wso2.carbon.identity.saml.model.ResponseBuilderConfig;
import org.wso2.carbon.identity.saml.request.IdPInitRequest;
import org.wso2.carbon.identity.saml.request.SAML2SSORequest;

import java.io.Serializable;
import java.util.Map;

/**
 * MessageContext specific to Inbound SAML2 SSO.
 */
public class MessageContext extends AuthenticationContext {

    private static final long serialVersionUID = 104634801939285909L;

    private String name;
    private String id;
    private String spEntityId;
    private String assertionConsumerUrl;
    private String destination;
    private String subject;
    private int attributeConsumingServiceIndex;
    private boolean isPassive;
    private boolean isForce;

    private RequestValidatorConfig requestValidatorConfig;
    private ResponseBuilderConfig responseBuilderConfig;

    public MessageContext(SAML2SSORequest request, Map<Serializable, Serializable> parameters) {
        super(request, parameters);
    }

    @Override
    public SAML2SSORequest getIdentityRequest() {
        return (SAML2SSORequest) identityRequest;
    }

    @Override
    public SAML2SSORequest getInitialAuthenticationRequest() {
        return (SAML2SSORequest) initialAuthenticationRequest;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        if (!isIdpInitSSO()) {
            return this.id;
        }
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSPEntityId() {
        return spEntityId;
    }

    public void setSPEntityId(String spEntityId) {
        this.spEntityId = spEntityId;
    }

    public String getAssertionConsumerURL() {
        return this.assertionConsumerUrl;
    }

    public void setAssertionConsumerUrl(String assertionConsumerUrl) {
        this.assertionConsumerUrl = assertionConsumerUrl;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAttributeConsumingServiceIndex() {
        return attributeConsumingServiceIndex;
    }

    public void setAttributeConsumingServiceIndex(int attributeConsumingServiceIndex) {
        this.attributeConsumingServiceIndex = attributeConsumingServiceIndex;
    }

    public boolean isPassive() {
        return this.isPassive;
    }

    public void setPassive(boolean isPassive) {
        this.isPassive = isPassive;
    }

    public boolean isForce() {
        return this.isForce;
    }

    public void setForce(boolean isForce) {
        this.isForce = isForce;
    }

    public String getRelayState() {
        return this.getIdentityRequest().getRelayState();
    }

    public boolean isIdpInitSSO() {
        return this.getIdentityRequest() instanceof IdPInitRequest;
    }

    public String getIssuerWithDomain() {
        return this.spEntityId;
    }

    public ResponseBuilderConfig getResponseBuilderConfig() {
        return responseBuilderConfig;
    }

    public void setResponseBuilderConfig(ResponseBuilderConfig responseBuilderConfig) {
        this.responseBuilderConfig = responseBuilderConfig;
    }

    public RequestValidatorConfig getRequestValidatorConfig() {
        return requestValidatorConfig;
    }

    public void setRequestValidatorConfig(RequestValidatorConfig requestValidatorConfig) {
        this.requestValidatorConfig = requestValidatorConfig;
    }
}
