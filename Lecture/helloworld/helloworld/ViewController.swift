//
//  ViewController.swift
//  helloworld
//
//  Created by Oceane Andreis on 8/29/19.
//  Copyright © 2019 Oceane Andreis. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

   //IBoutlet is so we can edit the hello world (as in color and size of it) and it's a place holder for hello world so it goes a certain place on the screen
    @IBOutlet weak var messageText: UILabel!
    
    @IBAction func buttonPressed(_ sender: UIButton) {
        messageText.text?="Hello World!"
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

