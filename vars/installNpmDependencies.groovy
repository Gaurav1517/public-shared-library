def call() {
    sh 'npm cache clean --force'
    sh 'rm -rf node_modules'
    sh 'npm install'
}
