/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2022 The ZAP Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.addon.network.internal.server.http;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Set;
import org.zaproxy.addon.network.internal.server.ServerConfig;
import org.zaproxy.addon.network.server.Server;

/** The default server configuration. */
public class DefaultServerConfig implements ServerConfig {

    private boolean anyLocalAddress;

    public DefaultServerConfig() {
        setAddress(Server.DEFAULT_ADDRESS);
    }

    public void setAddress(String address) {
        this.anyLocalAddress = isAnyLocalAddress(address);
    }

    @Override
    public boolean isAnyLocalAddress() {
        return anyLocalAddress;
    }

    @Override
    public Set<String> getAliases() {
        return Collections.emptySet();
    }

    @Override
    public boolean isBehindNat() {
        return false;
    }

    private static boolean isAnyLocalAddress(String address) {
        try {
            return address.isEmpty() || InetAddress.getByName(address).isAnyLocalAddress();
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
