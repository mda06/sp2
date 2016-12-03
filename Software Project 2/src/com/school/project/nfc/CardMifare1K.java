package com.school.project.nfc;

import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

import com.school.project.util.HexUtils;

public class CardMifare1K {
	public static final int SECTOR_COUNT = 16;
	public static final int PER_SECTOR_BLOCK_COUNT = 4;

	private byte keyNumber = KEY_LOCATION.ZERO.getValue();
	private byte keyType = KEY_TYPE.A.getValue();

	private CardChannel channel;
	private Card card;

	public CardMifare1K(Card card, byte nb, byte type) {
		this.card = card;
		keyNumber = nb;
		keyType = type;
		channel = card.getBasicChannel();
	}

	public Card getCard() {
		return card;
	}

	public StringBuilder getDump() {
		StringBuilder builder = new StringBuilder();
		try {
			// 1 authentication per sector
			byte blockNumber = 0x00;
			for (int i = 0; i < SECTOR_COUNT * PER_SECTOR_BLOCK_COUNT; i++) {
				if (blockNumber % (PER_SECTOR_BLOCK_COUNT) == 0) {
					authentificate(blockNumber);
				}
				builder.append("Section " + blockNumber / PER_SECTOR_BLOCK_COUNT + (blockNumber / PER_SECTOR_BLOCK_COUNT < 10 ? " " : "") + " Block "
						+ blockNumber % PER_SECTOR_BLOCK_COUNT + ":\t");

				builder.append(HexUtils.bytesToHexString(readBinaryBlock(blockNumber++).getData()) + "\n");
			}
		} catch (CardException c) {
			c.printStackTrace();
		}
		return builder;
	}

	public void print() {
		System.out.println(getDump().toString());
	}

	public ResponseAPDU getUID() throws CardException {
		byte p1 = 0x00;
		byte[] bytes = { (byte) 0xFF, (byte) 0xCA, p1, 0x00, 00 };
		ResponseAPDU answer = channel.transmit(new CommandAPDU(bytes));
		return answer;
	}

	public ResponseAPDU loadAuthenticateKeys(byte[] key) throws CardException {
		byte keyStructure = 0x00;
		byte[] bytes = new byte[5 + 6];
		bytes[0] = (byte) 0xFF;
		bytes[1] = (byte) 0x82;
		bytes[2] = keyStructure;
		bytes[3] = keyNumber;
		bytes[4] = (byte) 0x06;
		for (int i = 0; i < 6; i++)
			bytes[5 + i] = key[i];
		ResponseAPDU answer = channel.transmit(new CommandAPDU(bytes));
		return answer;
	}

	public ResponseAPDU authentificate(byte blockNumber) throws CardException {
		byte[] aid = { (byte) 0xFF, (byte) 0x86, 0x00, 0x00, 0x05, 0x01, 0x00, blockNumber, keyType, keyNumber };
		ResponseAPDU answer = channel.transmit(new CommandAPDU(aid));
		return answer;
	}

	public ResponseAPDU updateBinaryBlock(byte blockNumber, byte[] data) throws CardException {
		byte nbBytes = 0x10;
		byte[] bytes = new byte[5 + 16];
		bytes[0] = (byte) 0xFF;
		bytes[1] = (byte) 0xD6;
		bytes[2] = (byte) 0x00;
		bytes[3] = blockNumber;
		bytes[4] = nbBytes;
		for (int i = 0; i < 16; i++)
			bytes[5 + i] = data[i];
		ResponseAPDU answer = channel.transmit(new CommandAPDU(bytes));
		return answer;
	}

	public ResponseAPDU readBinaryBlock(byte blockNumber) throws CardException {
		byte nbBytes = 0x10;
		byte[] read = { (byte) 0xFF, (byte) 0xB0, 0x00, blockNumber, nbBytes };
		ResponseAPDU answer = channel.transmit(new CommandAPDU(read));
		return answer;
	}

	public void disconnect() {
		try {
			card.disconnect(false);
		} catch (CardException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return card.toString();
	}
}
