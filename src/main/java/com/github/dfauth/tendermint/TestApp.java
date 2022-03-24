package com.github.dfauth.tendermint;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tendermint.abci.ABCIApplicationGrpc;
import tendermint.abci.Types;

import java.io.IOException;

public class TestApp extends ABCIApplicationGrpc.ABCIApplicationImplBase {

    private static final Logger logger = LoggerFactory.getLogger(TestApp.class);

    public static final void main(String[] args) throws IOException {
        new TestApp().start();
        System.in.read();
    }

    public void start() throws IOException {
        var server = new GrpcServer(this, 26658);
        server.start();
    }

    @Override
    public void echo(Types.RequestEcho request, StreamObserver<Types.ResponseEcho> responseObserver) {
        var resp = Types.ResponseEcho.newBuilder().build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
        logger.info("echo");
    }

    @Override
    public void flush(Types.RequestFlush request, StreamObserver<Types.ResponseFlush> responseObserver) {
        super.flush(request, responseObserver);
        logger.info("flush");
    }

    @Override
    public void info(Types.RequestInfo request, StreamObserver<Types.ResponseInfo> responseObserver) {
        var resp = Types.ResponseInfo.newBuilder().build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
        logger.info("info");
    }

    @Override
    public void deliverTx(Types.RequestDeliverTx request, StreamObserver<Types.ResponseDeliverTx> responseObserver) {
        logger.info("deliverTx");
    }

    @Override
    public void checkTx(Types.RequestCheckTx request, StreamObserver<Types.ResponseCheckTx> responseObserver) {
        logger.info("checkTx");
    }

    @Override
    public void query(Types.RequestQuery request, StreamObserver<Types.ResponseQuery> responseObserver) {
        logger.info("query");
    }

    @Override
    public void commit(Types.RequestCommit request, StreamObserver<Types.ResponseCommit> responseObserver) {
        logger.info("commit");
    }

    @Override
    public void initChain(Types.RequestInitChain request, StreamObserver<Types.ResponseInitChain> responseObserver) {
        logger.info("initChain");
    }

    @Override
    public void beginBlock(Types.RequestBeginBlock request, StreamObserver<Types.ResponseBeginBlock> responseObserver) {
        logger.info("beginBlock");
    }

    @Override
    public void endBlock(Types.RequestEndBlock request, StreamObserver<Types.ResponseEndBlock> responseObserver) {
        logger.info("endBlock");
    }

    @Override
    public void listSnapshots(Types.RequestListSnapshots request, StreamObserver<Types.ResponseListSnapshots> responseObserver) {
        logger.info("listSnapshots");
    }

    @Override
    public void offerSnapshot(Types.RequestOfferSnapshot request, StreamObserver<Types.ResponseOfferSnapshot> responseObserver) {
        logger.info("offerSnapshot");
    }

    @Override
    public void loadSnapshotChunk(Types.RequestLoadSnapshotChunk request, StreamObserver<Types.ResponseLoadSnapshotChunk> responseObserver) {
        logger.info("loadSnapshotChunk");
    }

    @Override
    public void applySnapshotChunk(Types.RequestApplySnapshotChunk request, StreamObserver<Types.ResponseApplySnapshotChunk> responseObserver) {
        logger.info("applySnapshotChunk");
    }
}
