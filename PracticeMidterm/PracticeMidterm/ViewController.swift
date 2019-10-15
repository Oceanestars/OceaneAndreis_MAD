//
//  ViewController.swift
//  PracticeMidterm
//
//  Created by Oceane Andreis on 10/13/19.
//  Copyright © 2019 Oceane Andreis. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var Text: UITextView!
    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var segmented: UISegmentedControl!
    @IBOutlet weak var img: UIImageView!
    @IBOutlet weak var fontsize: UIStepper!
    @IBOutlet weak var slider: UISlider!
    @IBOutlet weak var sliderlabel: UILabel!
    @IBOutlet weak var sizeLabel: UILabel!
    @IBOutlet weak var switchoutlet: UISwitch!
    
    
    @IBAction func changepic(_ sender: UISegmentedControl) {
        if segmented.selectedSegmentIndex == 0{
            label.text="fun work"
            img.image=UIImage(named: "noun_Project_2651528")
        } else if segmented.selectedSegmentIndex == 1{
            label.text="Not so fun work"
            img.image=UIImage(named: "noun_Project_2076916-1")
        }
       
    }
    
    func changeColor(){
        let blueColor = UIColor(red: 0/255.0, green: 0/255.0, blue: 255/255.0, alpha: 1.0)
        let redColor = UIColor(red: 255/255.0, green: 0/255.0, blue: 0/255.0, alpha: 1.0)

        if switchoutlet.isOn {
            label.textColor = blueColor;

        } else {
            label.textColor = redColor;

        }
        
    }
    
    @IBAction func stepperAction(_ sender: UIStepper) {
        if fontsize.value == 7 {
            sizeLabel.text = "7 pt"
        } else {
            sizeLabel.text = String(format: "%.0f", fontsize.value) + " pt"
        }
        
        let fontSize = sender.value //using the stepper value
        let fontSizeCGFloat=CGFloat(fontSize)
        label.font=UIFont.systemFont(ofSize: fontSizeCGFloat)
        
    }
    
    @IBAction func switchAction(_ sender: UISwitch) {
        changeColor()
        
    }
    

    @IBAction func hardSlide(_ sender: UISlider) {
        let fontSize = sender.value
        sliderlabel.text=String(format: "%.0f", fontSize)

    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
        
    }
    @objc func dismissKeyboard(){
        view.endEditing(true)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}

