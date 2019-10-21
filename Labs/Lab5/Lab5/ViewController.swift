//
//  ViewController.swift
//  Lab5
//
//  Created by Oceane Andreis
//  Copyright (c) Oceane Andreis. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var firstItem: UILabel!
    @IBOutlet weak var secondItem: UILabel!
    
    @IBOutlet weak var thirdItem: UILabel!
    
    var user=items()
    
    @IBAction func unwindSegue (_ segue:UIStoryboardSegue){
        firstItem.text=user.itemholder
        secondItem.text=user.itemholder2
//        thirdItem.text=user.itemholder3
   }
        
        
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

