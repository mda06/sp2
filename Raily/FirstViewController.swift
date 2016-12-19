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
        self.getFromJSON()
    
    }
        func getFromJSON()
    {
        let url = NSURL(string: "https://irail.be/stations/NMBS")
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
                    
                    let graph=responseString["@graph"] as? [AnyObject] //posts started with array
                    
                    for post in graph!
                    {
                            let name = post["name"] as! String
                        print(name)
//                        let txtId = "http://irail.be/stations/NMBS/007015400"
//                        let id = post["@id"] as! String
//                        if(txtId == id){
//                            print(post["name"] as! String)
//                        }
                        
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

