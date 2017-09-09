package com.laining.alogrithms.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolGraph {

    private final Map<String, Integer> map;
    private final Graph graph;
    private final String[] keys;

    public SymbolGraph(File file, String delimeter) throws IOException {
        assert file != null && file.exists();
        map = new HashMap<String, Integer>();
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String lineText = null;
            while ((lineText = reader.readLine()) != null) {
                lines.add(lineText);
                String[] pair = lineText.split(delimeter);
                for (String key : pair) {
                    if (!map.containsKey(key)) {
                        map.put(key, map.size());
                    }
                }
            }
            keys = new String[map.size()];
            graph = new Graph(map.size());
            initGraph(lines, delimeter);
            initKeys();
        }

    }

    protected void initKeys() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            keys[entry.getValue()] = entry.getKey();
        }
    }

    protected void initGraph(List<String> lines, String delimete) throws IOException {
        for (String line : lines) {
            String[] pairs = line.split(delimete);
            if (pairs.length > 1) {
                String key = pairs[0];
                int v = map.get(key);
                for (int i = 1; i < pairs.length; i++) {
                    int w = map.get(pairs[i]);
                    graph.addEdge(v, w);
                }
            }
        }
    }

    public boolean contains(String key) {
        return map.containsKey(key);
    }

    public int index(String key) {
        return map.get(key);
    }

    public String name(int index) {
        return keys[index];
    }

    public Graph graph() {
        return graph;
    }

}
