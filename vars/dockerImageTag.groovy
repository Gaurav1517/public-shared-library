def call() {
    sh "docker tag ${IMAGE_TAG} ${IMAGE_NAME}:v${BUILD_NUMBER}"
    sh "docker tag ${IMAGE_TAG} ${IMAGE_NAME}:latest"
}
def call(String JOB_NAME, int BUILD_NUMBER, String docker_user) {
    sh """
        docker tag ${JOB_NAME}:v${BUILD_NUMBER} ${docker_user}/${JOB_NAME}:latest
    """
}
