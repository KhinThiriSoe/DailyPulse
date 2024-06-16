import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        // Initialize the shared code
        KoinInitializerKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}