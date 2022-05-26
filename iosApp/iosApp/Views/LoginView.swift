//
//  LoginView.swift
//  iosApp
//
//  Created by Nasir Ahmed Momin on 24/05/22.
//  Copyright © 2022 Mutual Mobile. All rights reserved.
//

import Foundation
import SwiftUI
import shared


class AuthStore: ObservableObject {
    @Published var hasFocus: Bool = true
    @Published var showLoading = false
    
    @Published var loginError: Error?
}

struct LoginView: View {
    
    @ObservedObject private var store = AuthStore()
    
    @Environment(\.dismiss) var dismiss
    
    @State private var email = "anmol@mutualmobile.com"
    @State private var password = "password"
    
    @FocusState private var nameIsFocused: Bool
    
    var body: some View {
        VStack {
            googleSignInButton
            LabelledDivider(label: "or", color: ColorAssets.white.color)
            credentialView
            footerView
        }
        .frame(width: UIScreen.main.bounds.width,
               height: UIScreen.main.bounds.height)
        .background(ColorAssets.colorBackground.color)
        .edgesIgnoringSafeArea(.all)
        .loadingIndicator(show: store.showLoading)
    }
    
    private var googleSignInButton: some View {
        Button {
            // TODO: (Nasir) Need to handle
        } label: {
            // TODO: (Nasir) Need to remove this entire HStack for Google Sign In, Must use button provided by Google pod
            HStack {
                Image("Google-Icon").padding(.trailing)
                Text("Sign In with Google").padding(.leading)
            }
            .harvestButton()
        }
        .padding(.bottom)
    }
    
    private var credentialView: some View {
        VStack {
            VStack {
                TextField("Work Email", text: $email)
                    .padding(.bottom)
                    .focused($nameIsFocused)
                
                SecureField("Password", text: $password)
            }
            .padding(.horizontal)
            .textFieldStyle(RoundedBorderTextFieldStyle())
            
            signinButton
                .padding(.vertical)
        }
        .padding(.horizontal)
        .onChange(of: nameIsFocused) { newValue in
            self.store.hasFocus = newValue
        }
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) {
                nameIsFocused = self.store.hasFocus
            }
        }
    }
    
    private var signinButton: some View {
        Button {
            performLogin()
        } label: {
            Text("Sign In")
                .harvestButton()
        }
    }
    
    var footerView: some View {
        VStack {
            HStack {
                Text("Don't have an account?")
                Button {
                    // TODO: (Nasir) Handle action
                } label: {
                    Text("Try Harvest Free")
                        .font(.headline)
                }
            }
            .padding(.bottom)
            
            Button {
                dismiss()
            } label: {
                Text("View Tour")
                    .font(.title3)
            }
        }
        .foregroundColor(ColorAssets.white.color)
    }
    
    private func performLogin() {
        LoginDataModel { state in
            
            
            print("state \(type(of: state)) \(state)")
           
            
        }.login(email: email, password: password)
    }
}

#if DEBUG
struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
#endif
