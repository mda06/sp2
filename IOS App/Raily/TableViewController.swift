//
//  TableViewController.swift
//  Raily
//
//  Created by Pieter Samoy on 15/12/16.
//  Copyright © 2016 com.pieter. All rights reserved.
//

import UIKit

//https://grokswift.com/rest-tableview-in-swift/


class TableViewController: UITableViewController {
    
    var TableData:Array< String > = Array < String >()
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return TableData.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
        
        cell.textLabel?.text = TableData[indexPath.row]
        
        return cell
    }

}
