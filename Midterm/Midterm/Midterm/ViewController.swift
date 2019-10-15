//
//  ViewController.swift
//  Midterm
//
//  Created by Oceane Andreis on 10/15/19.
//  Copyright © 2019 Oceane Andreis. All rights reserved.
//
//Assume car speed is 20 mph
//Average car gets 24 miles/gallon
//So if Total_mile = 20
//Then Total_time = 60 min
//Then Total_gas = 0.83 gallons (so divide mile by 24 to get num of gallons)
//20 days per month so arbitrary number

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    
    @IBOutlet weak var sliderLabel: UILabel!
    @IBOutlet weak var Segmented_control: UISegmentedControl!
    @IBOutlet weak var img_transport: UIImageView!
    @IBOutlet weak var Total_miles: UITextField!
    @IBOutlet weak var Total_time: UILabel!
    @IBOutlet weak var Total_gas: UILabel!
    
    @IBOutlet weak var Switch_outlet: UISwitch!
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    func calc(){
        var time:Float
        var gas:Float
        var miles:Float
       
       
        
        if Total_miles.text!.isEmpty {
            time = 0.0
        }
        else {
            
            time = Float(Total_miles.text!)! //miles
        
        }
        
        if Total_gas.text!.isEmpty {
            gas = 0.0 //I tried the gas for car and I kept getting nill so I deleted stuff so that my code could still work and that I could work on other things
        }
//        else {
//
//            gas = Float(Total_gas.text!)! //miles
//
//
//        }
        
        if Segmented_control.selectedSegmentIndex == 0{
            time = Float(Total_miles.text!)! //miles
            gas = time/24.00
            miles = time/20.00 //miles divide by 20 will give us the time
            miles = miles*60.0
            let currencyFormatter = NumberFormatter()
            Total_time.text = currencyFormatter.string(from: NSNumber(value: miles))
            Total_gas.text = currencyFormatter.string(from: NSNumber(value: gas))
            
            
        } else if Segmented_control.selectedSegmentIndex == 1{
            
            time = Float(Total_miles.text!)! //miles
            miles = time/12.00 //miles divide by 20 will give us the time
             miles = (miles*60.0)+5
            let currencyFormatter = NumberFormatter()
            Total_time.text = currencyFormatter.string(from: NSNumber(value: miles))
            //Total_gas.text = currencyFormatter.string(from: NSNumber(value: gas))
        }
        else if Segmented_control.selectedSegmentIndex == 2{
         
            time = Float(Total_miles.text!)! //miles
            miles = time/10.00 //miles divide by 20 will give us the time
             miles = miles*60.0
            let currencyFormatter = NumberFormatter()
            Total_time.text = currencyFormatter.string(from: NSNumber(value: miles))
            //Total_gas.text = currencyFormatter.string(from: NSNumber(value: gas))
           
        }
        
    }
    
    
    @IBAction func Calculate(_ sender: UIButton) {
        
        calc()
        
    }
    
    @IBAction func Slide_num(_ sender: UISlider) {
        
        let gas_num = sender.value
        sliderLabel.text=String(format: "%.0f", gas_num)+" gallons"
        if (gas_num<5)
        {
            //create a UIAlertController object
            let alert=UIAlertController(title: "Warning", message: "The number of gallon must be greater than 5", preferredStyle: UIAlertController.Style.alert)
            //create a UIAlertAction object for the button
            let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
               
                self.Total_gas.text? = "0"
                self.Total_time.text? = "0"
               
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        }
    }
    
    
    @IBAction func Mode_transport(_ sender: UISegmentedControl) {
        
        
        if Segmented_control.selectedSegmentIndex == 0{
            
            img_transport.image=UIImage(named: "car_icon.png")
        } else if Segmented_control.selectedSegmentIndex == 1{
            
            img_transport.image=UIImage(named: "bus_icon.png")
                Total_gas.text = "0"
        }
        else if Segmented_control.selectedSegmentIndex == 2{
            
            img_transport.image=UIImage(named: "bike_icon.png")
            Total_gas.text = "0"
        }
    }
    
    
    @IBAction func Monthly(_ sender: UISwitch) {
        //Month
        
        var time:Float
        var gas:Float
        var miles:Float
        
        
        
        if Total_miles.text!.isEmpty {
            time = 0.0
        }
        else {
            
            time = Float(Total_miles.text!)! //miles
            
        }
        
        if Total_gas.text!.isEmpty {
            gas = 0.0
        }
        
        if Switch_outlet.isOn{
        if Segmented_control.selectedSegmentIndex == 0{
            time = Float(Total_miles.text!)! //miles
            gas = time/24.00
            miles = time/20.00 //miles divide by 20 will give us the time
            miles = miles*60.0
            miles = miles*20.0
            let currencyFormatter = NumberFormatter()
            Total_time.text = currencyFormatter.string(from: NSNumber(value: miles))
            Total_gas.text = currencyFormatter.string(from: NSNumber(value: gas))
            
            
        } else if Segmented_control.selectedSegmentIndex == 1{
            
            time = Float(Total_miles.text!)! //miles
            miles = time/12.00 //miles divide by 20 will give us the time
            miles = (miles*60.0)+5
                miles = miles*20.0
            let currencyFormatter = NumberFormatter()
            Total_time.text = currencyFormatter.string(from: NSNumber(value: miles))
            //Total_gas.text = currencyFormatter.string(from: NSNumber(value: gas))
        }
        else if Segmented_control.selectedSegmentIndex == 2{
            
            time = Float(Total_miles.text!)! //miles
            miles = time/10.00 //miles divide by 20 will give us the time
            miles = miles*60.0
            miles = miles*20.0
            let currencyFormatter = NumberFormatter()
            Total_time.text = currencyFormatter.string(from: NSNumber(value: miles))
            //Total_gas.text = currencyFormatter.string(from: NSNumber(value: gas))
            
        }
        }
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

