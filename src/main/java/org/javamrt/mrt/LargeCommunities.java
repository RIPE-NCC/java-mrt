package org.javamrt.mrt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargeCommunities implements Attribute {
  private List<LargeCommunity> largeCommunities;

  LargeCommunities(byte[] buffer, int numberOfCommunities) {
    largeCommunities = new ArrayList<>();
    for (int i = 0; i < numberOfCommunities; i++) {
      byte[] part = Arrays.copyOfRange(buffer, i * 12, (i + 1) * 12);
      largeCommunities.add(new LargeCommunity(part));
    }
  }

  List<LargeCommunity> getLargeCommunities() {
    return largeCommunities;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    sb.append(largeCommunities.stream()
        .map(LargeCommunity::toString).collect(Collectors.joining(", ")));
    sb.append("]");
    return sb.toString();
  }
}
