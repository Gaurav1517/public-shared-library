def call() {
    sh "docker run -d --name ${JOB_NAME_LOWER} -p 3000:3000 ${IMAGE_NAME}:latest"
}
