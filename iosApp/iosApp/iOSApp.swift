import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        #if DEBUG
        ApplicationKt.onCreate(isDebug: true)
        #else
        ApplicationKt.onCreate(isDebug: false)
        #endif
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}