//
//  ViewController.swift
//  Project1Milestone3
//
//  Created by Oceane Andreis on 10/3/19.
//  Copyright © 2019 Oceane Andreis. All rights reserved.
//https://learnappmaking.com/random-numbers-swift/
//https://stackoverflow.com/questions/6748473/ios-create-a-link-button

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var infoHolder: UITextView!
    @IBOutlet weak var buttonImage: UIImageView!
    @IBOutlet weak var linkButton: UIButton!
    var link = ""

    @IBAction func allButton(_ sender: UIButton) {
        if sender.tag == 0 {
          
            buttonImage.image=UIImage(named: "health")
            let healthFact = ["Remedy for cold:Citrus fruit, Mint, Garlic, Ginger, Cayenne Pepper","Remedy for anxiety:Lavender, Aloe Vera, Sago Palm, Jasmine, Rosemary",]
            infoHolder.text=healthFact[0]
            linkButton.isHidden=false
            link = "https://www.asla.org/healthbenefitsofnature.aspx"
            
        }
        else if sender.tag == 1 {
            buttonImage.image=UIImage(named: "clothes")
            let clothesFact = ["Cotton is a great source for clothes","The production of (non-organic) cotton destroys farmland and pollutes waterways. "]
            infoHolder.text=clothesFact[0]
            linkButton.isHidden=false;
            link = "https://www.cottonique.com/blogs/blog/1943882-why-clothes-are-bad-for-the-environment"
        }
        else if sender.tag == 2 {
            buttonImage.image=UIImage(named: "food")
            let foodFact = ["Animal agriculture contributes about 14.5% of the world’s greenhouse gasses","10 billion birds are slaughtered every year in the US leading to environmental pollution resulting from carcasses",]
            infoHolder.text=foodFact[0]
            linkButton.isHidden=false
            link = "https://www.allrecipes.com/recipes/156/bread/"
        }
        else if sender.tag == 3 {
            buttonImage.image=UIImage(named: "energy")
            let energyFact = ["Clean energy includes renewable energy, energy efficiency and efficient combined heat and power.","Biomass, is a renewable organic matter, and can include biological material derived from living, or recently living organisms",]
            infoHolder.text=energyFact[0]
            linkButton.isHidden=false
            link = "https://en.wikipedia.org/wiki/Renewable_energy"
        }
        else if sender.tag == 4 {
            buttonImage.image=UIImage(named: "nature")
            let natureFact = ["Changing air pressure means that the weather will change. If you feel low air pressure that means that rain clouds are nearby.","Ancient people closely observed the behavior of animals to predict weather changes.",]
            infoHolder.text=natureFact[0]
            linkButton.isHidden=false
             link = "https://www.outdoorrevival.com/old-ways/predict-weather-using-nature-signs.html"
        }
        else if sender.tag == 5 {
            buttonImage.image=UIImage(named: "shelter")
            let shelterFact = ["You need to learn how to make the foundation of a house","don't finance anything in your home that won't last the length of your mortgage such as a stove, refrigerator, dishwasher.",]
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
//        self.view.backgroundColor = [UIColor, colorWithPatternImage,:[UIImage imageNamed:@"Artboard 24@4x"]]

       

    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

