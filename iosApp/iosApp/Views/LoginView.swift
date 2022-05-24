//
//  LoginView.swift
//  iosApp
//
//  Created by Nasir Ahmed Momin on 24/05/22.
//  Copyright © 2022 Mutual Mobile. All rights reserved.
//

import Foundation
import SwiftUI

struct LoginView: View {
    
    @Environment(\.dismiss) var dismiss
    
    @State private var email = ""
    @State private var password = ""
    @FocusState private var nameIsFocused: Bool
    
    private var buttonWidth: CGFloat {
        UIScreen.main.bounds.width - 70
    }
    
    private var buttonRadius: Double {
        10.0
    }
    
    var body: some View {
        VStack {
            Spacer().frame(height: UIScreen.main.bounds.height * 0.1)
            googleSignInButton
            LabelledDivider(label: "or", color: ColorAssets.white.color)
            credentialView
            footerView
        }
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) {
                nameIsFocused = true
            }
        }
        .frame(width: UIScreen.main.bounds.width,
               height: UIScreen.main.bounds.height,
               alignment: .center)
        .background(ColorAssets.colorBackground.color)
        .edgesIgnoringSafeArea(.all)
    }
    
    private var googleSignInButton: some View {
        Button {
            // TODO: (Nasir) Need to handle
        } label: {
            HStack {
                Image("") // TODO: (Nasir) add Google icon
                Text("Sign In with Google")
            }
            .foregroundColor(.black)
            .font(.title3)
            .padding()
            .frame(width: buttonWidth)
            .background(ColorAssets.white.color)
            .cornerRadius(buttonRadius)
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
    }
    
    private var signinButton: some View {
        Button {
            // TODO: (Nasir) Handle action
            nameIsFocused.toggle() // Just for testing
        } label: {
            Text("Sign In")
                .foregroundColor(.black)
                .font(.title3)
                .padding()
        }
        .frame(width: buttonWidth)
        .background(ColorAssets.white.color)
        .cornerRadius(buttonRadius)
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
}

#if DEBUG
struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
#endif

// From: https://stackoverflow.com/questions/56619043/show-line-separator-view-in-swiftui
struct LabelledDivider: View {
    
    let label: String
    let horizontalPadding: CGFloat
    let color: Color
    
    init(label: String, horizontalPadding: CGFloat = 10, color: Color = .black) {
        self.label = label
        self.horizontalPadding = horizontalPadding
        self.color = color
    }
    
    var body: some View {
        HStack {
            line
            Text(label)
                .foregroundColor(color)
            line
        }.padding(.horizontal)
    }
    
    var line: some View {
        VStack {
            Divider()
                .background(color)
        }
        .padding(horizontalPadding)
    }
}
