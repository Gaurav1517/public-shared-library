def call(Map params = [:]) {
    // Set default values for projectName and projectKey if not provided
    def projectName = params.get('projectName', 'default-project-name')
    def projectKey = params.get('projectKey', 'default-project-key')

    stage("Sonarqube Analysis") {
        steps {
            withSonarQubeEnv('sonar-server') {
                sh """
                    \$SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=${projectName} \
                    -Dsonar.projectKey=${projectKey}
                """
            }
        }
    }
}
