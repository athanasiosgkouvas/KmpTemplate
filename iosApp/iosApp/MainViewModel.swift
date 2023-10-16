import Foundation
import shared

public protocol MainViewModelType {
    var state: MainActivityContractState { get set }
}

public class MainViewModel: MainActivityViewModel, ObservableObject, MainViewModelType{
    @Published var state: MainActivityContractState = MainActivityContractState(
        message: ""
    )

     override init() {
        super.init()

        collect(flow: uiState) { state in
              guard let state = state as? MainActivityContractState else {
                return
              }
              self.state = state

              print(state)
            }
     }
}