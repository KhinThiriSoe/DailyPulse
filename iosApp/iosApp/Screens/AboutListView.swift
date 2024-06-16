//
//  AboutScreen.swift
//  iosApp
//
//  Created by Khin on 10/6/2567 BE.
//  Copyright © 2567 BE orgName. All rights reserved.
//

import shared
import SwiftUI

struct AboutListView: View {
  private struct RowItem: Hashable {
    let title: String
    let subtitle: String
  }

  private let items: [RowItem] = {
    let platform = Platform()
    platform.logSystemInfo()

    var result: [RowItem] = [
      .init(
        title: "Operating System",
        subtitle: "\(platform.osName) \(platform.osVersion)"
      ),
      .init(
        title: "Device",
        subtitle: platform.deviceModel
      ),
      .init(
        title: "Density",
        subtitle: "@\(platform.density)x"
      )
    ]
    return result
  }()

  var body: some View {
    List {
      ForEach(items, id: \.self) { item in
        VStack(alignment: .leading) {
            if #available(iOS 17.0, *) {
                Text(item.title)
                    .font(.footnote)
                    .foregroundStyle(.secondary)
            } else {
                // Fallback on earlier versions
            }
            if #available(iOS 15.0, *) {
                Text(item.subtitle)
                    .font(.body)
                    .foregroundStyle(.primary)
            } else {
                // Fallback on earlier versions
            }
        }
        .padding(.vertical, 4)
      }
    }
  }
}
