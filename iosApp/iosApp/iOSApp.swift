import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        #if DEBUG
        ApplicationKt.onCreate(isDebug: true)
        #endif
        ApplicationKt.onCreate(isDebug: false)
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}