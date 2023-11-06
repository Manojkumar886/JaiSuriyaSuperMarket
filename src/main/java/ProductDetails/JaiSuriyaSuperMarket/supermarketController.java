package ProductDetails.JaiSuriyaSuperMarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Supermarket")
//http://localhost:8082/Supermarket
public class supermarketController
{
    @Autowired
    supermarketService serv;


//    http://localhost:8082/create
    //after request mapping
//    //http://localhost:8082/Supermarket/create
    @PostMapping("/create")
     public String creation(@RequestBody supermarketEntity Productdetails)
    {
        return serv.makecreate(Productdetails).getProductName()+" has been added successfullly";
    }

//    http://localhost:8082/Supermarket
    @GetMapping("/")
    public List<supermarketEntity> listall()
    {
        return serv.viewall();
    }


    @PutMapping("/update")
    public String updating(@RequestBody supermarketEntity productdetails)
    {
        supermarketEntity temp=serv.makecreate(productdetails);
        return temp.getProductName()+" has beem updated successfully";
    }

    @GetMapping("/readone/{count}")
    public Optional<supermarketEntity> showone(@PathVariable ("count")int count)
    {
        return  serv.readone(count);
    }

    @DeleteMapping("/deleteone/{count}")
    public String deleteone(@PathVariable("count")int count)
    {
       return serv.removeone(count)+" deleted";
    }

}
