//
//  ViewController.swift
//
//
//  Created by Oceane Andreis
//  Copyright (c) Oceane Andreis. All rights reserved.
// Use Human interface guidelines.
// Have width and height restriction for pictures and button

import UIKit

class ViewController: UIViewController {
    
    //IB outlet
    @IBOutlet weak var chickenLabel: UILabel!
    @IBOutlet weak var chickenImage: UIImageView!
    @IBOutlet weak var imageControl: UISegmentedControl!
    @IBOutlet weak var capSwitch: UISwitch!
    @IBOutlet weak var sizeLabel: UILabel!
    
    
    
    //Function
    func updateImage(){
        if imageControl.selectedSegmentIndex == 0 {
            chickenLabel.text="sweet Chicken"
            chickenLabel.textColor = UIColor(red: 1, green: 0, blue: 1, alpha: 1)
            chickenImage.image=UIImage(named: "sweet")
        }
        else if imageControl.selectedSegmentIndex == 1 {
            chickenLabel.text="Beijing chicken"
             chickenLabel.textColor = UIColor(red: 0, green: 0, blue: 1, alpha: 1)
            chickenImage.image=UIImage(named: "beijing")
        }
    }
    
    func updateCaps(){
        if capSwitch.isOn {
            chickenLabel.text=chickenLabel.text?.uppercased()
        } else {
            chickenLabel.text=chickenLabel.text?.lowercased()
        }
    }
    
    
    //Action
    @IBAction func changeInfo(_ sender: UISegmentedControl) {
        updateImage()
        updateCaps()
    }
    
    @IBAction func updateFont(_ sender: UISwitch) {
       updateCaps()
    }
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        let fontSize=sender.value //float
        sizeLabel.text=String(format: "%.0f", fontSize) //convert float to String
        let fontSizeCGFloat=CGFloat(fontSize) //convert float to CGFloat
        chickenLabel.font=UIFont.systemFont(ofSize: fontSizeCGFloat) //create a UIFont object and assign to the font property
    }
    
    
    //Override functions
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

