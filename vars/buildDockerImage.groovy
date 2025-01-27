def call(Map params = [:]) {
    def dockerImageName = params.get('dockerImageName', "${JOB_NAME_LOWER}")
    def dockerTag = params.get('dockerTag', "${BUILD_NUMBER}")
    
    script {
        sh "docker build -t ${dockerImageName}:${dockerTag} ."
    }
}
