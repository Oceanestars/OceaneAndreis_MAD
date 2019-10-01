//
//  ViewController.swift

//
//  Created by Oceane Andreis
//  Copyright Oceane Andreis. All rights reserved.
//https://learnappmaking.com/found-nil-while-unwrapping-optional-value/

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var originalAmount: UITextField!
    @IBOutlet weak var savingDue: UILabel!
    @IBOutlet weak var totalDue: UILabel!
    @IBOutlet weak var percentStepper: UIStepper!
    @IBOutlet weak var percentLabel: UITextField!
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    @IBAction func updatePeople(_ sender: UIStepper) {
        if percentStepper.value == 1 {
            percentLabel.text = "1%"
        } else {
            percentLabel.text = String(format: "%.0f", percentStepper.value) + " %"
        }
        updateTotal()
    }
    
    func updateTotal() {
        var amount:Double //check amount
        var pct = percentStepper.value //saving percentage


        if originalAmount.text!.isEmpty {
           amount = 0.0
        }
        else {
            amount = Double(originalAmount.text!)!
        }
       
        pct = pct/100
        let saving=amount * pct
        let total=amount-saving
        
        //format results as currency
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle=NumberFormatter.Style.currency //set the number style
        savingDue.text=currencyFormatter.string(from: NSNumber(value: saving)) //returns a formatted string
        totalDue.text=currencyFormatter.string(from: NSNumber(value: total))
        
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateTotal()
    }
    
    override func viewDidLoad() {
        originalAmount.delegate=self
        super.viewDidLoad()
        
//        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillShow), name: UIResponder.keyboardWillShowNotification, object: nil)
//        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillHide), name: UIResponder.keyboardWillHideNotification, object: nil)
        
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
            view.addGestureRecognizer(tap)
        
    }
    @objc func dismissKeyboard(){
        view.endEditing(true)
    }
    
    //Code below handy if the text field was lower on the screen
    
//    @objc func keyboardWillShow(notification: NSNotification){
//        if let keyboardSize = (notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue)?.cgRectValue{
//            if self.view.frame.origin.y == 0 {
//                self.view.frame.origin.y -= keyboardSize.height
//            }
//        }
//    }
//    @objc func keyboardWillHide(notification: NSNotification){
//        if((notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue)?.cgRectValue)
//            != nil{
//            if self.view.frame.origin.y != 0 {
//                self.view.frame.origin.y = 0
//            }
//        }
    //}


    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

