//
//  Scene2ViewController.swift
//  Lab5
//
//  Created by Oceane Andreis
//  Copyright (c) Oceane Andreis. All rights reserved.
//

import UIKit

class Scene2ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var itemOne: UITextField!
    @IBOutlet weak var itemTwo: UITextField!
    @IBOutlet weak var itemThree: UITextField!
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "done"{
            let scene1ViewController = segue.destination as! ViewController
            //check to see that text was entered in the textfields
            if itemOne.text!.isEmpty == false{
                scene1ViewController.user.itemholder=itemOne.text
            }
            if itemTwo.text!.isEmpty == false{
                scene1ViewController.user.itemholder2=itemTwo.text
            }
//            if itemThree.text!.isEmpty == false{
//                scene1ViewController.user.itemholder3=itemThree.text
//            }
           
        }
    }
    
    override func viewDidLoad() {
        itemOne.delegate=self
        itemTwo.delegate=self
//        itemThree.delegate=self
        
        
        super.viewDidLoad()
    }

    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue!, sender: AnyObject!) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
