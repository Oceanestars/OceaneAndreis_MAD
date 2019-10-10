//
//  ViewController.swift
//  Project1Milestone3
//
//  Created by Oceane Andreis on 10/3/19.
//  Time spent on this: 15h~
//  I spent a lot of time trying to do things that didn't work
//  Spent 1/4 of that time on constraints
//  Copyright © 2019 Oceane Andreis. All rights reserved.
//https://learnappmaking.com/random-numbers-swift/
//https://stackoverflow.com/questions/6748473/ios-create-a-link-button

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var infoHolder: UITextView!
    @IBOutlet weak var buttonImage: UIImageView!
    @IBOutlet weak var linkButton: UIButton!
    var link = ""
    //I tried to implement a next button so I could go through those arrays. but the way I
    //would affect the textview was through the six buttons
    //The next button would of had to affect the correct array.
    //I tried a for loop and I moved the arrays inside and outside but it wasn't working
    // I basically needed a button inside a button.
    //So When I clicked the health button it would make the next button appear and then that
    //next button would be an ibaction so it could affect the textview and go through the array
    //i looked everywhere on the internet to be able to have a button inside a button
    //I tried to do different to tackle the problem but wasn't successful.
    
    //PSEUDOCODE for my next button
  //if health button pressed
       // Then next button appear
        //if next button pressed
            //for loop through health array
                // infoholder.text = health[i]
    //if food button pressed
        // Then next button appear
        //if next button pressed
            //for loop through food array
                // infoholder.text = food[i]
    
    let healthFact = ["Remedy for cold:Citrus fruit, Mint, Garlic, Ginger, Cayenne Pepper","Remedy for anxiety:Lavender, Aloe Vera, Sago Palm, Jasmine, Rosemary",]
    let clothesFact = ["Cotton is a great source for clothes","The production of (non-organic) cotton destroys farmland and pollutes waterways. "]
    let foodFact = ["Animal agriculture contributes about 14.5% of the world’s greenhouse gasses","10 billion birds are slaughtered every year in the US leading to environmental pollution resulting from carcasses",]
    

    let energyFact = ["Clean energy includes renewable energy, energy efficiency and efficient combined heat and power.","Biomass, is a renewable organic matter, and can include biological material derived from living, or recently living organisms",]
     let natureFact = ["Changing air pressure means that the weather will change. If you feel low air pressure that means that rain clouds are nearby.","Ancient people closely observed the behavior of animals to predict weather changes.",]
    let shelterFact = ["You need to learn how to make the foundation of a house","don't finance anything in your home that won't last the length of your mortgage such as a stove, refrigerator, dishwasher.",]

    let welcomeMess = ["Welcome to Survivre I hope you get to learn a lot about you and the planet", "Welcome, we are not doomed yet so here are some great things to know", "Welcome, we only have a few years to live so here is what you need to know"]
    
    @IBAction func allButton(_ sender: UIButton) {
        if sender.tag == 0 {
          
            buttonImage.image=UIImage(named: "health")

            infoHolder.text=healthFact[0]
            linkButton.isHidden=false
            link = "https://www.asla.org/healthbenefitsofnature.aspx"
            
        }
        else if sender.tag == 1 {
            buttonImage.image=UIImage(named: "clothes")

            infoHolder.text=clothesFact[0]
            linkButton.isHidden=false;
            link = "https://www.cottonique.com/blogs/blog/1943882-why-clothes-are-bad-for-the-environment"
        }
        else if sender.tag == 2 {
            buttonImage.image=UIImage(named: "food")

            infoHolder.text=foodFact[0]
            linkButton.isHidden=false
            link = "https://www.allrecipes.com/recipes/156/bread/"
        }
        else if sender.tag == 3 {
            buttonImage.image=UIImage(named: "energy")

            infoHolder.text=energyFact[0]
            linkButton.isHidden=false
            link = "https://en.wikipedia.org/wiki/Renewable_energy"
        }
        else if sender.tag == 4 {
            buttonImage.image=UIImage(named: "nature")

            infoHolder.text=natureFact[0]
            linkButton.isHidden=false
             link = "https://www.outdoorrevival.com/old-ways/predict-weather-using-nature-signs.html"
        }
        else if sender.tag == 5 {
            buttonImage.image=UIImage(named: "shelter")

            infoHolder.text=shelterFact[0]
            linkButton.isHidden=false
            link = "https://www.thespruce.com/building-your-own-house-1821301"
        }
    }
    @IBAction func openLink(_ sender: UIButton) {
        if let open_link = URL(string: link) {
            UIApplication.shared.open(open_link)
        }
    }
    
    func randomFunc(){
    let randomFact = ["Almond milk takes a lot of water", "Cows produce a fifth of the world's methane", "Nuclear energy is the cheapest renewable energy", "California, Oregon, and Washington should be expecting a gigantic earthquake", "Tea bag produce micro plastic"]
        
        let randomName = randomFact.randomElement()
        print(randomName as Any)
        infoHolder.text=randomName
    }
    
    
    override func viewDidLoad() {

        super.viewDidLoad()
        randomFunc()

    }

    //Tried to get an alert at the beginning
//    override func viewDidAppear(_ animated: Bool) {
//        let alert = UIAlertController(title: "Quick Poll", message: "Do you believe in climate change?(This info will help us serve you better)", preferredStyle: .alert)
//
//        alert.addAction(UIAlertAction(title: "Yes", style: .default, handler: nil))
//        alert.addAction(UIAlertAction(title: "No", style: .cancel, handler: nil))
//    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

