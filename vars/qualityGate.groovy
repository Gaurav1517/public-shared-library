def call(Map params = [:]) {
    // Default values for Quality Gate configuration
    def credentialsId = params.get('credentialsId', 'sonar-token')
    def abortPipeline = params.get('abortPipeline', false)

    script {
        waitForQualityGate abortPipeline: abortPipeline, credentialsId: credentialsId
    }
}
