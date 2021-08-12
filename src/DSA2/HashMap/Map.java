package DSA2.HashMap;

import java.util.ArrayList;

public class Map<K,V> {
    ArrayList<MapNode<K,V>> buckets;
    int size;
    int numBuckets;
    Map()
    {
        buckets=new ArrayList<>();
        size=0;
        numBuckets=5;
        for(int i=0;i<20;i++)
        {
            buckets.add(null);
        }
    }

    public double getLoadFactor()
    {
        return (size*0.1)/numBuckets;
    }

    public V getValue(K key)
    {
        int pos=getBucketNumber(key);
        MapNode<K,V> root=buckets.get(pos);
        while (root!=null)
        {
            if(root.key.equals(key))
            {
                return root.value;
            }
            root=root.next;
        }
        return null;
    }

    public V delete(K key)
    {
        int post=getBucketNumber(key);
        MapNode<K,V> root=buckets.get(post);
        MapNode<K,V> prev=null;
        while (root!=null)
        {
            if(root.key.equals(key))
            {
                size--;
                if(prev==null)
                {
                    buckets.set(post,root.next);
                    return root.value;
                }
                else
                {
                    prev.next=root.next;
                    return root.value;
                }
            }
            prev=root;
            root=root.next;
        }
        return null;
    }

    public void insert(K key,V value)
    {
        int pos=getBucketNumber(key);
        MapNode<K,V> node=new MapNode<>(key,value);
        MapNode<K,V> head= buckets.get(pos);
        while (head!=null)
        {
            if(head.key.equals(key))
            {
                head.value=value;
                return;
            }
            head=head.next;
        }
        head= buckets.get(pos);
        node.next=head;
        buckets.set(pos,node);
        if(getLoadFactor()>0.7)
        {
            rehashing();
        }
        size++;
    }

    private void rehashing() {
        System.out.println("Rehashing in process...");
        ArrayList<MapNode<K,V>> temp=buckets;
        buckets=new ArrayList<>();
        for(int i=0;i<numBuckets*2;i++)
        {
            buckets.add(null);
        }
        size=0;
        numBuckets*=2;
        for(int i=0;i< temp.size();i++)
        {
            MapNode<K,V> node=temp.get(i);
            while (node!=null)
            {
                insert(node.key,node.value);
                node=node.next;
            }
        }
    }

    private int getBucketNumber(K key)
    {
        return key.hashCode()%numBuckets;
    }

}
