def call() {
    sh "docker tag ${IMAGE_TAG} ${IMAGE_NAME}:v${BUILD_NUMBER}"
    sh "docker tag ${IMAGE_TAG} ${IMAGE_NAME}:latest"
}
