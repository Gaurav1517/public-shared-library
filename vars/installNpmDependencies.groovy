def call() {
    sh 'npm install -g npm@latest'
    sh 'npm cache clean --force'
    sh 'rm -rf node_modules'
    sh 'npm install'
}
