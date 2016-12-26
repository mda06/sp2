////
////  TableViewController.swift
////  Raily
////
////  Created by Pieter Samoy on 19/12/16.
////  Copyright © 2016 com.pieter. All rights reserved.
////
//
//import UIKit
//import Alamofire
//
//class TableViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
//
//    override func viewDidLoad() {
//        super.viewDidLoad()
//
//        // Do any additional setup after loading the view.
//    }
//
//    override func didReceiveMemoryWarning() {
//        super.didReceiveMemoryWarning()
//        // Dispose of any resources that can be recreated.
//    }
//    
//    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
//        return 0
//    }
//    
//    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
//        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
//        return cell
//    }
//    
//    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
//        
//    }
//    class StationNames {
//        var stationName: [allStations]?
//    }
//    enum stations: String {
//        case Name = "name"
//    }
//    
//    class allStations {
//        var station: String?
//        
//        required init(json: [String: Any]) {
//            self.station = json[stations.Name.rawValue] as? String
//        }
//        
//        class func endpointForSpecies() -> String {
//            return "https://api.irail.be/connections/?to=Aalst&from=Ninove&format=json"
//        }
//        private class func speciesArrayFromResponse(_ response: DataResponse<Any>) -> Result<StationNames> {
//            // TODO: implement
//        }
//        
//        fileprivate class func getSpeciesAtPath(_ path: String, completionHandler: @escaping (Result<StationNames>) -> Void) {
//            // make sure it's HTTPS because sometimes the API gives us HTTP URLs
//            guard var urlComponents = URLComponents(string: path) else {
//                let error = BackendError.urlError(reason: "Tried to load an invalid URL")
//                completionHandler(.failure(error))
//                return
//            }
//            urlComponents.scheme = "https"
//            guard let url = try? urlComponents.asURL() else {
//                let error = BackendError.urlError(reason: "Tried to load an invalid URL")
//                completionHandler(.failure(error))
//                return
//            }
//            let _ = Alamofire.request(url)
//                .responseJSON { response in
//                    if let error = response.result.error {
//                        completionHandler(.failure(error))
//                        return
//                    }
//                    let StationNamesResult = StationNames.speciesArrayFromResponse(response)
//                    completionHandler(StationNamesResult)
//            }
//        }
//        
//        class func getSpecies(_ completionHandler: @escaping (Result<SpeciesWrapper>) -> Void) {
//            getSpeciesAtPath(StarWarsSpecies.endpointForSpecies(), completionHandler: completionHandler)
//        }
//        
//        class func getMoreSpecies(_ wrapper: SpeciesWrapper?, completionHandler: @escaping (Result<SpeciesWrapper>) -> Void) {
//            guard let nextURL = wrapper?.next else {
//                let error = BackendError.objectSerialization(reason: "Did not get wrapper for more species")
//                completionHandler(.failure(error))
//                return
//            }
//            getSpeciesAtPath(nextURL, completionHandler: completionHandler)
//        }
//    }
//    }
//}
