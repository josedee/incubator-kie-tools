/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class PipelineVars implements Serializable {

    String githubRepositoryOrg = 'apache';
    String githubRepositoryName = 'incubator-kie-tools';
    String githubRepositorySlug = 'apache/incubator-kie-tools';

    String quayPushCredentialsId = 'quay-io-kie-tools-token';
    String openshiftCredentialsId = 'openshift-kie-tools-token';
    String kieToolsBotGithubCredentialsId = 'kie-tools-bot-gh';
    String kieToolsBotGithubTokenCredentialsId = 'kie-tools-bot-gh-token';
    String kieToolsGithubCodeQLTokenCredentialsId = 'kie-tools-gh-codeql-token';
    String chromeStoreCredentialsId = 'kie-tools-chrome-store';
    String chromeStoreRefreshTokenCredentialsId = 'kie-tools-chrome-store-refresh-token';
    String npmTokenCredentialsId = 'kie-tools-npm-token';
    String buildKiteTokenCredentialsId = 'kie-tools-build-kite-token';

    String defaultArtifactsTempDir = 'artifacts-tmp';

}

return new PipelineVars();