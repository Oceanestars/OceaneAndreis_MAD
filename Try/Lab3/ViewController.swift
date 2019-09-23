//
//  ViewController.swift
//  Lab3
//
//  Created by Oceane Andreis on 9/22/19.
//  Copyright © 2019 Oceane Andreis. All rights reserved.
//
//change an image
//change the text in a label
//change the size of text in a label
//change the capitalization of the text in a label
//change either the font or text color of the text in a label

import UIKit


class ViewController: UIViewController {

    
    @IBOutlet weak var fontSizeLabel: UILabel!
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var switchControl: UISwitch!
    @IBOutlet weak var segControl: UISegmentedControl!
    @IBOutlet weak var label: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    
    func updateImage(){
        if segControl.selectedSegmentIndex == 0 {
            label.text="Orange Chicken"
            imageView.image=UIImage(named: "chicken")
        }
        else if segControl.selectedSegmentIndex == 1 {
            label.text="Beijing Chicken"
            imageView.image=UIImage(named: "beijing")
        }
    }
    
    func updateCaps(){
        if switchControl.isOn {
            label.text=label.text?.uppercased()
        } else {
            label.text=label.text?.lowercased()
        }
    }

    @IBAction func slideAction(_ sender: UISlider) {
        let fontSize=sender.value //float
        fontSizeLabel.text=String(format: "%.0f", fontSize)
        let fontSizeCGFloat=CGFloat(fontSize)
        label.font=UIFont.systemFont(ofSize: fontSizeCGFloat) 
    }
    
    @IBAction func switchAction(_ sender: UISwitch) {
          updateCaps()
    }
    
    @IBAction func segAction(_ sender: UISegmentedControl) {
        updateImage()
        updateCaps()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
}

