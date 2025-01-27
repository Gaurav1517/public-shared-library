def call() {
    // Trivy File Scan
    sh "trivy fs --format table -o trivy-fs-report.html ."
}
