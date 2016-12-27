//
//  FirstViewController.swift
//  Raily
//
//  Created by Pieter Samoy on 14/12/16.
//  Copyright © 2016 com.pieter. All rights reserved.
//

import UIKit

class FirstViewController: UIViewController{

    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    @IBOutlet weak var whereFrom: UITextField!
    @IBOutlet weak var whereTo: UITextField!
    @IBAction func searchButton(_ sender: Any) {
        self.getFromJSON()

    }
        func getFromJSON()
    {
        let whereFrom = self.whereFrom.text
        let whereTo = self.whereTo.text
        let url = NSURL(string: "https://api.irail.be/connections/?to=" + whereTo! + "&from=" + whereFrom! + "&format=json")
       
        let request = NSMutableURLRequest(url:url! as URL)
        
        let task = URLSession.shared.dataTask(with: request as URLRequest) {data,response,error in
            guard error == nil && data != nil else
            {
                print("Error:",error as Any)
                return
            }
            
            let httpStatus = response as? HTTPURLResponse
            
            if httpStatus!.statusCode == 200
            {
                if data?.count != 0
                {
                    let responseString = try! JSONSerialization.jsonObject(with: data!, options: .allowFragments) as! NSDictionary //because JSON data started with dictionary. not array.
                    //let time = responseString["current_time"] //number or strings
                   // print(String(describing: time)) //convert to string if it number
                    
                    let connection=responseString["connection"] as? [AnyObject] //posts started with array
                   
                    
                    for post in connection!
                    {
                        let departure = post["departure"] as! NSDictionary
                        let depStationName = departure["station"] as! String
                        
                        let arrival = post["arrival"] as! NSDictionary
                        let arrStationName = arrival["station"] as! String
                       
                        var duration = post["duration"] as! String
                        let durationSec = Int(duration)!/60
                        
                        print("From: " + depStationName)
                        print("To: " + arrStationName)
                        print("Duration: " + String(durationSec))
                        print(" ")
                    }
                    
                    
                }
                else{
                    print("no data got from url")
                }
                
            }
            else
            {
                print("error httpstatus code is: ", httpStatus!.statusCode)
            }
        }
        task.resume()
        
    }

    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }
    
  
}

