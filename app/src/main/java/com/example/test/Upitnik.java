package com.example.test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class Upitnik extends Contract {
    private static final String BINARY = "60806040526004805464ffffffffff19166105001790553480156200002357600080fd5b5060405162000e1538038062000e15833981810160405260a08110156200004957600080fd5b81019080805160405193929190846401000000008211156200006a57600080fd5b9083019060208201858111156200008057600080fd5b82516401000000008111828201881017156200009b57600080fd5b82525081516020918201929091019080838360005b83811015620000ca578181015183820152602001620000b0565b50505050905090810190601f168015620000f85780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156200011c57600080fd5b9083019060208201858111156200013257600080fd5b82516401000000008111828201881017156200014d57600080fd5b82525081516020918201929091019080838360005b838110156200017c57818101518382015260200162000162565b50505050905090810190601f168015620001aa5780820380516001836020036101000a031916815260200191505b5060405260200180516040519392919084640100000000821115620001ce57600080fd5b908301906020820185811115620001e457600080fd5b8251640100000000811182820188101715620001ff57600080fd5b82525081516020918201929091019080838360005b838110156200022e57818101518382015260200162000214565b50505050905090810190601f1680156200025c5780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156200028057600080fd5b9083019060208201858111156200029657600080fd5b8251640100000000811182820188101715620002b157600080fd5b82525081516020918201929091019080838360005b83811015620002e0578181015183820152602001620002c6565b50505050905090810190601f1680156200030e5780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156200033257600080fd5b9083019060208201858111156200034857600080fd5b82516401000000008111828201881017156200036357600080fd5b82525081516020918201929091019080838360005b838110156200039257818101518382015260200162000378565b50505050905090810190601f168015620003c05780820380516001836020036101000a031916815260200191505b506040525050600080546001600160a01b03191633179055508451620003ee90600190602088019062000575565b5060408051808201909152848152600060208083018290526003805460018101808355919093528351805191949360020260008051602062000df58339815191520192620004429284929091019062000575565b50602091820151600191820155604080518082019091528681526000818401819052600380549384018082559152815180519195509193600290930260008051602062000df58339815191520192620004a092849291019062000575565b50602091820151600191820155604080518082019091528581526000818401819052600380549384018082559152815180519195509193600290930260008051602062000df58339815191520192620004fe92849291019062000575565b50602091820151600191820155604080518082019091528481526000818401819052600380549384018082559152815180519195509193600290930260008051602062000df583398151915201926200055c92849291019062000575565b506020820151816001015550505050505050506200061a565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620005b857805160ff1916838001178555620005e8565b82800160010185558215620005e8579182015b82811115620005e8578251825591602001919060010190620005cb565b50620005f6929150620005fa565b5090565b6200061791905b80821115620005f6576000815560010162000601565b90565b6107cb806200062a6000396000f3fe608060405234801561001057600080fd5b50600436106100ea5760003560e01c8063477b49521161008c57806377ab2e3a1161006657806377ab2e3a146102b95780638da5cb5b146102c1578063c802baa7146102e5578063e1d5bcf614610306576100ea565b8063477b4952146101ca57806354afb49a146101d25780635696c04b1461026e576100ea565b806335ca84e1116100c857806335ca84e11461013557806338226abf146101b25780633a88d0b2146101ba5780633c0cb3b1146101c2576100ea565b806316ea8154146100ef5780632d8a513514610111578063319061ec14610119575b600080fd5b61010f6004803603602081101561010557600080fd5b503560030b61032c565b005b61010f6103bb565b610121610471565b604080519115158252519081900360200190f35b61013d61047a565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561017757818101518382015260200161015f565b50505050905090810190601f1680156101a45780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61013d610526565b61013d610586565b61013d610596565b61013d6105a6565b6101ef600480360360208110156101e857600080fd5b50356105b6565b6040518080602001838152602001828103825284818151815260200191508051906020019080838360005b8381101561023257818101518382015260200161021a565b50505050905090810190601f16801561025f5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b6102946004803603602081101561028457600080fd5b50356001600160a01b0316610669565b604080519315158452600392830b90920b602084015282820152519081900360600190f35b61013d610690565b6102c961071d565b604080516001600160a01b039092168252519081900360200190f35b6102ed61072c565b60408051600392830b90920b8252519081900360200190f35b61010f6004803603602081101561031c57600080fd5b50356001600160a01b031661073a565b3360009081526002602052604090205460ff161561034957600080fd5b60045460ff161561035957600080fd5b3360009081526002602052604090208054600383810b63ffffffff81166101000264ffffffffff19909316929092178355600190920154825490929190811061039e57fe5b600091825260209091206001600290920201018054909101905550565b6000546001600160a01b031633146103d257600080fd5b60045460ff16156103e257600080fd5b6004805460ff191660011790556000805b60035481101561046d576003818154811061040a57fe5b906000526020600020906002020160010154821015610465576003818154811061043057fe5b60009182526020909120600290910201600101546004805464ffffffff00191661010063ffffffff600386900b160217905591505b6001016103f3565b5050565b60045460ff1681565b60606003808154811061048957fe5b60009182526020918290206002918202018054604080516001831615610100026000190190921693909304601f81018590048502820185019093528281529290919083018282801561051c5780601f106104f15761010080835404028352916020019161051c565b820191906000526020600020905b8154815290600101906020018083116104ff57829003601f168201915b5050505050905090565b60018054604080516020601f6002600019610100878916150201909516949094049384018190048102820181019092528281526060939092909183018282801561051c5780601f106104f15761010080835404028352916020019161051c565b6060600360018154811061048957fe5b6060600360008154811061048957fe5b6060600360028154811061048957fe5b600381815481106105c357fe5b60009182526020918290206002918202018054604080516001831615610100026000190190921693909304601f8101859004850282018501909352828152909350918391908301828280156106595780601f1061062e57610100808354040283529160200191610659565b820191906000526020600020905b81548152906001019060200180831161063c57829003601f168201915b5050505050908060010154905082565b6002602052600090815260409020805460019091015460ff821691610100900460030b9083565b60018054604080516020600284861615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156107155780601f106106ea57610100808354040283529160200191610715565b820191906000526020600020905b8154815290600101906020018083116106f857829003601f168201915b505050505081565b6000546001600160a01b031681565b600454610100900460030b81565b6000546001600160a01b0316331461075157600080fd5b6001600160a01b03811660009081526002602052604090205460ff161561077757600080fd5b6001600160a01b0316600090815260026020526040902060019081015556fea265627a7a72315820a4d5506018bd50300b9965a58e4bffa85298ba52e9d1ce637b11ae385191cd5d64736f6c634300050b0032c2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b";

    public static final String FUNC_GLASAJ = "glasaj";

    public static final String FUNC_KRAJGLASANJA = "krajGlasanja";

    public static final String FUNC_UPITNIKUTOKU = "upitnikUToku";

    public static final String FUNC_GETODG4 = "getOdg4";

    public static final String FUNC_GETPITANJE = "getPitanje";

    public static final String FUNC_GETODG2 = "getOdg2";

    public static final String FUNC_GETODG1 = "getOdg1";

    public static final String FUNC_GETODG3 = "getOdg3";

    public static final String FUNC_ODGOVORI = "Odgovori";

    public static final String FUNC_GLASACI = "glasaci";

    public static final String FUNC_PITANJE = "pitanje";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_POBEDNIK = "pobednik";

    public static final String FUNC_DOZVOLAGLASANJA = "dozvolaGlasanja";

    @Deprecated
    protected Upitnik(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Upitnik(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Upitnik(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Upitnik(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> glasaj(int _glasnjaIndex) {
        final Function function = new Function(
                FUNC_GLASAJ,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int32(_glasnjaIndex)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> krajGlasanja() {
        final Function function = new Function(
                FUNC_KRAJGLASANJA,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> upitnikUToku() {
        final Function function = new Function(FUNC_UPITNIKUTOKU,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> getOdg4() {
        final Function function = new Function(FUNC_GETODG4,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getPitanje() {
        final Function function = new Function(FUNC_GETPITANJE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getOdg2() {
        final Function function = new Function(FUNC_GETODG2,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getOdg1() {
        final Function function = new Function(FUNC_GETODG1,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getOdg3() {
        final Function function = new Function(FUNC_GETODG3,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple2<String, BigInteger>> Odgovori(int param0) {
        final Function function = new Function(FUNC_ODGOVORI,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<String, BigInteger>>(
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<Tuple3<Boolean, BigInteger, BigInteger>> glasaci(String param0) {
        final Function function = new Function(FUNC_GLASACI,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Int32>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<Boolean, BigInteger, BigInteger>>(
                new Callable<Tuple3<Boolean, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<Boolean, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<Boolean, BigInteger, BigInteger>(
                                (Boolean) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue(),
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<String> pitanje() {
        final Function function = new Function(FUNC_PITANJE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> pobednik() {
        final Function function = new Function(FUNC_POBEDNIK,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> dozvolaGlasanja(String _glasac) {
        final Function function = new Function(
                FUNC_DOZVOLAGLASANJA,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_glasac)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Upitnik> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _pitanje, String odg1, String odg2, String odg3, String odg4) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_pitanje),
                new org.web3j.abi.datatypes.Utf8String(odg1),
                new org.web3j.abi.datatypes.Utf8String(odg2),
                new org.web3j.abi.datatypes.Utf8String(odg3),
                new org.web3j.abi.datatypes.Utf8String(odg4)));
        return deployRemoteCall(Upitnik.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Upitnik> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _pitanje, String odg1, String odg2, String odg3, String odg4) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_pitanje),
                new org.web3j.abi.datatypes.Utf8String(odg1),
                new org.web3j.abi.datatypes.Utf8String(odg2),
                new org.web3j.abi.datatypes.Utf8String(odg3),
                new org.web3j.abi.datatypes.Utf8String(odg4)));
        return deployRemoteCall(Upitnik.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Upitnik> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _pitanje, String odg1, String odg2, String odg3, String odg4) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_pitanje),
                new org.web3j.abi.datatypes.Utf8String(odg1),
                new org.web3j.abi.datatypes.Utf8String(odg2),
                new org.web3j.abi.datatypes.Utf8String(odg3),
                new org.web3j.abi.datatypes.Utf8String(odg4)));
        return deployRemoteCall(Upitnik.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Upitnik> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _pitanje, String odg1, String odg2, String odg3, String odg4) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_pitanje),
                new org.web3j.abi.datatypes.Utf8String(odg1),
                new org.web3j.abi.datatypes.Utf8String(odg2),
                new org.web3j.abi.datatypes.Utf8String(odg3),
                new org.web3j.abi.datatypes.Utf8String(odg4)));
        return deployRemoteCall(Upitnik.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static Upitnik load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Upitnik(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Upitnik load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Upitnik(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Upitnik load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Upitnik(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Upitnik load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Upitnik(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
