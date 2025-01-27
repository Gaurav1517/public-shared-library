def call() {
    dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'DP-Check'
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
