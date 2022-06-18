import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun comission_PaySystemVkPay() {
        val transAmount = 56000.0
        val monthAmount = 0.0
        val paySystem = "VK Pay"
        val stock = true

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(0.0, result, 1e-6)
    }
    @Test
    fun comission_PaySystemMirWithFixComission() {
        val transAmount = 35000.0
        val monthAmount = 0.0
        val paySystem = "Mir"
        val stock = true

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(3500.0, result, 1e-6)
    }

    @Test
    fun comission_PaySystemMirWithPercentComission() {
        val transAmount = 1200000.0
        val monthAmount = 0.0
        val paySystem = "Mir"
        val stock = true

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(9000.0, result, 1e-6)
    }

    @Test
    fun comission_PaySystemVisaWithFixComission() {
        val transAmount = 35000.0
        val monthAmount = 0.0
        val paySystem = "Visa"
        val stock = true

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(3500.0, result, 1e-6)
    }

    @Test
    fun comission_PaySystemVisaWithPercentComission() {
        val transAmount = 1200000.0
        val monthAmount = 0.0
        val paySystem = "Visa"
        val stock = true

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(9000.0, result, 1e-6)
    }

    @Test
    fun comission_PaySystemMastercardAddStockInLimit(){
        val transAmount = 25000.0
        val monthAmount = 30000.0
        val paySystem = "Mastercard"
        val stock = true

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(0.0, result, 1e-6)
    }
    @Test
    fun comission_PaySystemMaestroAddStockInLimit(){
        val transAmount = 25000.0
        val monthAmount = 30000.0
        val paySystem = "Maestro"
        val stock = true

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(0.0, result, 1e-6)
    }

    @Test
    fun comission_PaySystemMastercardAddStockOutLimit(){
        val transAmount = 25000.0
        val monthAmount = 7490000.0
        val paySystem = "Mastercard"
        val stock = true

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(2150.0, result, 1e-6)
    }
    @Test
    fun comission_PaySystemMaestroAddStockOutLimit(){
        val transAmount = 25000.0
        val monthAmount = 7490000.0
        val paySystem = "Maestro"
        val stock = true

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(2150.0, result, 1e-6)
    }

    @Test
    fun comission_PaySystemMastercardNotStock(){
        val transAmount = 250000.0
        val monthAmount = 0.0
        val paySystem = "Mastercard"
        val stock = false

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(3500.0, result, 1e-6)
    }
    @Test
    fun comission_PaySystemMaestroNotStock(){
        val transAmount = 250000.0
        val monthAmount = 0.0
        val paySystem = "Maestro"
        val stock = false

        val result = comission(transAmount,monthAmount, paySystem, stock)

        assertEquals(3500.0, result, 1e-6)
    }



    @Test
    fun transferVkPayInLimit() {
        val transAmount = 1300000.0
        val monthAmount = 0.0
        val paySystem = "VK Pay"
        val stock = true
        val dayAmount = 0.0

        val result = transfer(transAmount, monthAmount,paySystem,stock, dayAmount)

        assertEquals(1300000.0, result, 1e-6)
    }

    @Test
    fun transferVkPayOutLimit() {
        val transAmount = 1600000.0
        val monthAmount = 0.0
        val paySystem = "VK Pay"
        val stock = true
        val dayAmount = 0.0

        val result = transfer(transAmount, monthAmount,paySystem,stock, dayAmount)

        assertEquals(0.0, result, 1e-6)
    }

    @Test
    fun transferMastercardInLimit(){
        val transAmount = 1300000.0
        val monthAmount = 0.0
        val paySystem = "Mastercard"
        val stock = true
        val dayAmount = 0.0

        val result = transfer(transAmount, monthAmount,paySystem,stock, dayAmount)

        assertEquals(1300000.0, result, 1e-6)
    }

    @Test
    fun transferMaestroOutLimit() {
        val transAmount = 1300000.0
        val monthAmount = 0.0
        val paySystem = "Maestro"
        val stock = true
        val dayAmount = 14000000.0

        val result = transfer(transAmount, monthAmount, paySystem, stock, dayAmount)

        assertEquals(0.0, result, 1e-6)
    }

    @Test
    fun transferVisaOutLimit() {
        val transAmount = 1300000.0
        val monthAmount = 59800000.0
        val paySystem = "Maestro"
        val stock = true
        val dayAmount = 0.0

        val result = transfer(transAmount, monthAmount, paySystem, stock, dayAmount)

        assertEquals(0.0, result, 1e-6)
    }

    @Test
    fun MastercardOrMaestroStock_inLimit(){
        val transAmount = 35000.0
        val monthAmount = 60000.0

        val result = MastercardOrMaestroStock(transAmount, monthAmount)

        assertEquals(0.0, result, 1e-6)
    }

    @Test
    fun MastercardOrMaestroStock_outLimit(){
        val transAmount = 7000000.0
        val monthAmount = 1000000.0

        val result = MastercardOrMaestroStock(transAmount, monthAmount)

        assertEquals(44000.0, result, 1e-6)
    }


    @Test
    fun mainTest(){

        val result = main()

        assertEquals(680000.0, result, 1e-6)
    }

}