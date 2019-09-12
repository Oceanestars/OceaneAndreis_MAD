//
//  ViewController.swift
//  Lab1
//
//  Created by Oceane Andreis on 9/5/19.
//  Copyright © 2019 Oceane Andreis. All rights reserved.
//  https://icons8.com/icon/set/sushi/bubbles

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var sushiImage: UIImageView!
    
    @IBOutlet weak var sushiText: UITextField!
    
    
    @IBAction func SushiButton(_ sender: UIButton) {
        
        if sender.tag == 1 {
            sushiImage.image=UIImage(named: "SUSHI1")
            sushiText.text="Sushi is made with rice"
            
        }
        else if sender.tag == 2{
             sushiImage.image=UIImage(named: "SASHIMI1")
             sushiText.text="Sashimi is only raw fish"
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

