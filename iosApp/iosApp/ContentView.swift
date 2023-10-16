import SwiftUI
import shared

struct ContentView: View {

    @ObservedObject var viewModel: MainViewModel = MainViewModel()

	var body: some View {
		Text(viewModel.state.message)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}